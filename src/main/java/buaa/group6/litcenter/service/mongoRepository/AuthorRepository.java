package buaa.group6.litcenter.service.mongoRepository;

import buaa.group6.litcenter.model.Author;
import buaa.group6.litcenter.model.Literature;
import buaa.group6.litcenter.model.Magauthor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AuthorRepository extends MongoRepository<Magauthor,String> {
    Magauthor getById(String id);
    List<Magauthor> getByNormalizedNameContaining(String name);
    //这里使用normalized name查询，因为该字段已建立索引，而name字段无法建立
}
