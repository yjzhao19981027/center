package buaa.group6.litcenter.service.mongoRepository;

import buaa.group6.litcenter.model.Author;
import buaa.group6.litcenter.model.Literature;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AuthorRepository extends MongoRepository<Author,String> {
    Author getById(String id);
    List<Author> getByNameContaining(String name);
}
