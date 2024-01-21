package dev.app.oauth2.crudapp;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @param id
 * @param name
 * @param email
 * @param password
 * @author Anish Panthi
 */
@Table("OAUTH_USER")
public record User(

    @Id
    Long id,
    String name,
    String email,
    String password,
    Role role
) {

}
