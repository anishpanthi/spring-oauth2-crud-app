package dev.app.oauth2.crudapp;

import java.util.List;

/**
 * @author Anish Panthi
 */
public interface UserService {

  List<User> findAll();

  void save(User user);

}
