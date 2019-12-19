package buaa.group6.litcenter.service;

import buaa.group6.litcenter.model.User;
import buaa.group6.litcenter.service.mongoRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Primary
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getUsersByName(String name) {
        return userRepository.getByUsernameContaining(name);
    }
}
