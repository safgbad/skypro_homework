package pro.sky.course5.hw36.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {

  private Integer id;
  private String firstName;
  private String lastName;
  private String gender;
  private Integer age;
  private City city;

  public Employee(Integer id, String firstName, String lastName, String gender, Integer age) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.age = age;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", gender='" + gender + '\'' +
        ", age=" + age +
        (city == null ? "" : ", city=" + city) +
        '}';
  }
}
