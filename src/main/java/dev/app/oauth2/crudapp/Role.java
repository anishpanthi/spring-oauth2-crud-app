package dev.app.oauth2.crudapp;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("OAUTH_ROLE")
public record Role(@Id Long id, String role) {

}
