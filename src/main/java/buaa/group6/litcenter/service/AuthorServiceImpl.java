package buaa.group6.litcenter.service;

import buaa.group6.litcenter.model.Author;
import buaa.group6.litcenter.model.Magauthor;
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
    public Magauthor getAuthorByID(String id) {
        return authorRepository.getById(id);
    }
    @Override
    public List<Magauthor> getAuthorByName(String name) {
        return authorRepository.getByNormalizedNameContaining(name);
    }

    @Override
    public List<Magauthor> getTop5AuthorByName(String name) {
        return authorRepository.getTop5ByNormalizedNameStartingWith(name);
    }

}
