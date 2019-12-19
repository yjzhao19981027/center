package buaa.group6.litcenter.controller;

import buaa.group6.litcenter.container.UserPaging;
import buaa.group6.litcenter.container.authorPaging;
import buaa.group6.litcenter.model.Literature;
import buaa.group6.litcenter.util.tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    tools Tool = new tools();

    @ResponseBody
    @RequestMapping(value = "getUsersByPaging", method = RequestMethod.GET)
    public UserPaging getUsersByPaging(@RequestParam String name, String pageNumber){
        return Tool.getUsersByPaging(name,pageNumber);
    }
}
