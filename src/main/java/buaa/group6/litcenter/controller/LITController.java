package buaa.group6.litcenter.controller;

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
    @RequestMapping(value = "getLITs", method = RequestMethod.GET)
    public List<Literature> getLITs(@RequestParam String params){
        return Tool.getLITByTitle(params);
    }

    @RequestMapping(value = "getLIT", method = RequestMethod.GET)
    public Literature getLIT(@RequestParam String id){
        return Tool.getLITByID(id);
    }

    @RequestMapping(value = "getLITsByPaging", method = RequestMethod.GET)
    public List<Object> getLITs(@RequestParam String params,int pageNumber){
        return Tool.getByPaging(true,params,pageNumber);
    }
}
