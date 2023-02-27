package org.example.model;
import lombok.Value;

@Value(staticConstructor = "of")
public class User {
    long id;
    String username;
    String password;
}
