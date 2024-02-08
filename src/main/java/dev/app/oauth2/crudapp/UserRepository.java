package dev.app.oauth2.crudapp;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Anish Panthi
 */
@Repository
public interface UserRepository extends ListCrudRepository<User, Long> {}
