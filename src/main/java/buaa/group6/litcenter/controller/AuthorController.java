package buaa.group6.litcenter.controller;

import buaa.group6.litcenter.model.Author;

import buaa.group6.litcenter.util.tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
public class AuthorController {
    @Autowired
    tools Tool = new tools();

    @ResponseBody
    @RequestMapping(value = "getAuthor", method = RequestMethod.GET)
    public Author getAuthor(@RequestParam String id){
        return Tool.getAuthorByID(id);
    }

    @RequestMapping(value = "getAuthors",method = RequestMethod.GET)
    public List<Author> getAuthors(@RequestParam String params){
        return Tool.getAuthorByName(params);
    }

    @RequestMapping(value = "getAuthorsByPaging", method = RequestMethod.GET)
    public List<Object> getLITs(@RequestParam String params,int pageNumber){
        return Tool.getByPaging(false,params,pageNumber);
    }
}
