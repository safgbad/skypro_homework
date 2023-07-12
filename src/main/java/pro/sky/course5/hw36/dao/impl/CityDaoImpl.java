package pro.sky.course5.hw36.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pro.sky.course5.hw36.dao.CityDao;
import pro.sky.course5.hw36.model.City;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CityDaoImpl implements CityDao {

  private Connection connection;

  @Autowired
  public CityDaoImpl(DataSource dataSource) {
    try {
      this.connection = dataSource.getConnection();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void create(City city) {
    try (PreparedStatement statement = connection.prepareStatement(
        "INSERT INTO city (city_id, city_name) " +
            "VALUES ((?), (?))")) {
      statement.setInt(1, city.getCityId());
      statement.setString(2, city.getCityName());

      statement.executeQuery();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Integer getCityIdByCityName(String cityName) {
    Integer result = null;
    try (PreparedStatement statement = connection.prepareStatement(
        "SELECT city_id FROM city WHERE city_name = (?)")) {
      statement.setString(1, cityName);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        result = resultSet.getInt("city_id");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return result;
  }
}
