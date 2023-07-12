package pro.sky.course5.hw36;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pro.sky.course5.hw36.dao.EmployeeDao;
import pro.sky.course5.hw36.model.City;
import pro.sky.course5.hw36.model.Employee;

import javax.annotation.PostConstruct;

@Component
public class Application {

  private final EmployeeDao employeeDao;

  @Autowired
  public Application(EmployeeDao employeeDao) {
    this.employeeDao = employeeDao;
  }

  @PostConstruct
  public void run() {
    City city = new City(5, "Архангельск");
    Employee employee = new Employee(3,
        "Georgiy",
        "Zaharov",
        "male",
        35,
        city);
    employeeDao.create(employee);

    employee = new Employee(4,
        "Mariya",
        "Kaplan",
        "female",
        14);
    employeeDao.create(employee);

    System.out.println(employeeDao.readById(4));
    System.out.println();

    for (Employee empl : employeeDao.readAll()) {
      System.out.println(empl);
    }
  }
}
