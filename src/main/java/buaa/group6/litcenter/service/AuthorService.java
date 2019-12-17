package buaa.group6.litcenter.service;

import buaa.group6.litcenter.model.Author;

import java.util.List;

public interface AuthorService {
    Author getAuthorByID(String id);
    List<Author> getAuthorByName(String name);
}
