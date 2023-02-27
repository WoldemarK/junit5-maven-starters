package org.example.service;

import org.example.model.User;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserService {
    List<User> users = new ArrayList<>();

    public List<User> getAll() {
        return this.users;
    }

    public boolean add(User... user) {
        return this.users.addAll(Arrays.asList(user));
    }

    public Optional<User> login(String name, String password) {

        if (name == null || password == null) {
            throw new IllegalArgumentException("username or password is null");
        }
        return this.users
                .stream()
                .filter(user -> user.getUsername().equals(name))
                .filter(user -> user.getPassword().equals(password))
                .findFirst();
    }

    public Map<Long, User> getAllConvertedById() {
        return this.users
                .stream()
                .collect(Collectors.toMap(User::getId, Function.identity()));
    }
}
