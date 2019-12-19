package buaa.group6.litcenter.service.mongoRepository;

import buaa.group6.litcenter.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User,String> {
    List<User> getByUsernameContaining(String name);
}
