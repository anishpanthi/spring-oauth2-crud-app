package dev.app.oauth2.crudapp;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.simple.JdbcClient;

@SpringBootApplication
public class SpringOAuth2AndCrudApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringOAuth2AndCrudApplication.class, args);
  }

  @Bean
  ApplicationRunner applicationRunner(UserService userService) {
    return args -> {
      userService.save(
          new User(null, "Anish", "anish@panthi.com", "anish123", new Role(null, "ADMIN")));
      userService.save(new User(null, "Alan", "alan@alan.com", "alan123", new Role(null, "USER")));
      userService.findAll().forEach(System.out::println);
    };
  }
}
