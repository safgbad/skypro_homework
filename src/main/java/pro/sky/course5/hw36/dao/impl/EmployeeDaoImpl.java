package pro.sky.course5.hw36.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pro.sky.course5.hw36.dao.CityDao;
import pro.sky.course5.hw36.dao.EmployeeDao;
import pro.sky.course5.hw36.model.City;
import pro.sky.course5.hw36.model.Employee;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

  private Connection connection;
  private final CityDao cityDao;

  @Autowired
  public EmployeeDaoImpl(DataSource dataSource, CityDao cityDao) {
    try {
      this.connection = dataSource.getConnection();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    this.cityDao = cityDao;
  }

  // прошу простить меня за всё то, что я здесь написал
  @Override
  public void create(Employee employee) {
    String query;
    if (employee.getCity() != null) {
      query = "INSERT INTO employee (id, first_name, last_name, gender, age, city_id) " +
          "VALUES ((?), (?), (?), (?), (?), (?))";
    } else {
      query = "INSERT INTO employee (id, first_name, last_name, gender, age) " +
          "VALUES ((?), (?), (?), (?), (?))";
    }
    try (PreparedStatement statement = connection.prepareStatement(query)) {
      statement.setInt(1, employee.getId());
      statement.setString(2, employee.getFirstName());
      statement.setString(3, employee.getLastName());
      statement.setString(4, employee.getGender());
      statement.setInt(5, employee.getAge());

      if (employee.getCity() != null) {
        Integer cityId = cityDao.getCityIdByCityName(employee.getCity().getCityName());
        if (cityId == null) {
          cityDao.create(employee.getCity());
          cityId = employee.getCity().getCityId();
        }
        statement.setInt(6, cityId);
      }

      statement.executeQuery();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Employee readById(int id) {
    Employee employee = new Employee();
    try (PreparedStatement statement = connection.prepareStatement(
        "SELECT e.id, e.first_name, e.last_name, e.gender, e.age, e.city_id, c.city_name " +
            "FROM employee e " +
            "LEFT JOIN city c ON e.city_id = c.city_id " +
            "WHERE e.id = (?);")) {
      statement.setInt(1, id);
      ResultSet resultSet = statement.executeQuery();
      if (!resultSet.next()) {
        return null;
      }
      employee.setId(resultSet.getInt("id"));
      employee.setFirstName(resultSet.getString("first_name"));
      employee.setLastName(resultSet.getString("last_name"));
      employee.setGender(resultSet.getString("gender"));
      employee.setAge(resultSet.getInt("age"));
      String city_name = resultSet.getString("city_name");
      if (city_name != null) {
        City city = new City();
        city.setCityId(resultSet.getInt("city_id"));
        city.setCityName(city_name);
        employee.setCity(city);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return employee;
  }

  @Override
  public List<Employee> readAll() {
    List<Employee> employees = new ArrayList<>();
    try (PreparedStatement statement = connection.prepareStatement(
        "SELECT id FROM employee;");
         ResultSet resultSet = statement.executeQuery()) {
      while (resultSet.next()) {
        employees.add(readById(resultSet.getInt("id")));
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    return employees;
  }
}
