package org.example.service;

import org.example.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {
    List<User> users = new ArrayList<>();

    public List<User> getAll() {
        return this.users;
    }

    public boolean add(User user) {
        return this.users.add(user);
    }
    public Optional<User> login(String name, String password) {
        return this.users
                .stream()
                .filter(user -> user.getUsername().equals(name))
                .filter(user -> user.getPassword().equals(password))
                .findFirst();
    }
}
