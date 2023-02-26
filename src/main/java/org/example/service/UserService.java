package org.example.service;

import org.example.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    List<User> users = new ArrayList<>();

    public List<User> getAll() {
        return users;
    }

    public boolean add(User user) {
        return this.users.add(user);
    }
}
