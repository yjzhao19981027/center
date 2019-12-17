package buaa.group6.litcenter.service;

import buaa.group6.litcenter.model.Author;
import buaa.group6.litcenter.service.mongoRepository.AuthorRepository;
import buaa.group6.litcenter.service.mongoRepository.LITRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class AuthorServiceImpl implements AuthorService{
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Author getAuthorByID(String id) {
        return authorRepository.getById(id);
    }

    @Override
    public List<Author> getAuthorByName(String name) {
        return authorRepository.getByNameContaining(name);
    }
}
