package buaa.group6.litcenter.controller;

import buaa.group6.litcenter.container.authorPaging;
import buaa.group6.litcenter.model.Author;

import buaa.group6.litcenter.model.Magauthor;
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
    public Magauthor getAuthor(@RequestParam String id){
        return Tool.getAuthorByID(id);
    }

    @RequestMapping(value = "getAuthors",method = RequestMethod.GET)
    public List<Magauthor> getAuthors(@RequestParam String name){
        return Tool.getAuthorByName(name);
    }

    @RequestMapping(value = "getTop5Authors",method = RequestMethod.GET)
    public List<Magauthor> getTop5Authors(@RequestParam String name){
        return Tool.getTop5AuthorByName(name);
    }

    @RequestMapping(value = "getAuthorsByPaging", method = RequestMethod.GET)
    public authorPaging getAuthors(@RequestParam String name, String pageNumber){
        return Tool.getAuthorsByPaging(name,pageNumber);
    }
}
