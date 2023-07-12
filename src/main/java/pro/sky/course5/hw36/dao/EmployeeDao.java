package pro.sky.course5.hw36.dao;

import pro.sky.course5.hw36.model.Employee;

import java.util.List;

public interface EmployeeDao {

  void create(Employee employee);

  Employee readById(int id);

  List<Employee> readAll();
}
