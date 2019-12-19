package buaa.group6.litcenter.service;

import buaa.group6.litcenter.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsersByName(String name);
}
