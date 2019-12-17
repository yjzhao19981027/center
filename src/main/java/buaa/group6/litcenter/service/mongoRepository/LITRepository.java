package buaa.group6.litcenter.service.mongoRepository;

import buaa.group6.litcenter.model.Literature;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LITRepository extends MongoRepository<Literature,String> {
    List<Literature> getByTitleContaining(String keyword);
    List<Literature> getByTitle(String title);
    List<Literature> getByAuthor(String author);
    Literature getById(String Id);
}
