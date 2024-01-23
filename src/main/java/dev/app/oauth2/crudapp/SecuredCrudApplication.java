package dev.app.oauth2.crudapp;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecuredCrudApplication {

  public static void main(String[] args) {
    SpringApplication.run(SecuredCrudApplication.class, args);
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
