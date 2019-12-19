package buaa.group6.litcenter.service;

import buaa.group6.litcenter.model.Author;
import buaa.group6.litcenter.model.Magauthor;

import java.util.List;

public interface AuthorService {
    Magauthor getAuthorByID(String id);
    List<Magauthor> getAuthorByName(String name);
    List<Magauthor> getTop5AuthorByName(String name);
}
