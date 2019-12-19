package buaa.group6.litcenter.controller;

import buaa.group6.litcenter.container.LITPaging;
import buaa.group6.litcenter.util.tools;
import buaa.group6.litcenter.model.Literature;
import buaa.group6.litcenter.service.LITService;
import buaa.group6.litcenter.service.mongoRepository.LITRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class LITController {
    @Autowired
    tools Tool = new tools();

    @ResponseBody
    @RequestMapping(value = "getLIT", method = RequestMethod.GET)
    public Literature getLIT(@RequestParam String id){
        return Tool.getLITByID(id);
    }

    @RequestMapping(value = "getLITs", method = RequestMethod.GET)
    public List<Literature> getLITs(@RequestParam String title){
        return Tool.getLITByTitle(title);
    }

    @RequestMapping(value = "getLITsByPaging", method = RequestMethod.GET)
    public LITPaging getLITs(@RequestParam String title, String pageNumber){
        return Tool.getLITsByPaging(title,pageNumber);
    }
}
