package backend;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class LaufveranstaltungApplication {

  public static void main(String[] args) {
    SpringApplication.run(LaufveranstaltungApplication.class, args);
  }

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUrl("jdbc:postgresql://localhost:65026/postgres"); // Replace with your actual database URL
    dataSource.setUsername("postgres");
    dataSource.setPassword("password");
    return dataSource;
  }
}
