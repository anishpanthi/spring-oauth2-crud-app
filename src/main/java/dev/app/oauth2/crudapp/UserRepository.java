package dev.app.oauth2.crudapp;

import java.util.List;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

/**
 * @author Anish Panthi
 */
@Repository
public class UserRepository {

  private final JdbcClient jdbcClient;

  public UserRepository(JdbcClient jdbcClient) {
    this.jdbcClient = jdbcClient;
  }

  public List<User> findAll() {
    return jdbcClient.sql("SELECT * FROM users")
        .query(User.class).stream().toList();
  }
}
