package pro.sky.course5.hw36.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
public class DataSourceConfiguration {

  private final Environment environment;

  @Autowired
  public DataSourceConfiguration(Environment environment) {
    this.environment = environment;
  }

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
    driverManagerDataSource.setDriverClassName(Objects.requireNonNull(
        environment.getProperty("spring.datasource.driver-class-name")));
    driverManagerDataSource.setUrl(Objects.requireNonNull(
        environment.getProperty("spring.datasource.url")));
    driverManagerDataSource.setUsername(Objects.requireNonNull(
        environment.getProperty("spring.datasource.username")));
    driverManagerDataSource.setPassword(Objects.requireNonNull(
        environment.getProperty("spring.datasource.password")));

    return driverManagerDataSource;
  }
}
