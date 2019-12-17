package buaa.group6.litcenter.controller;

import buaa.group6.litcenter.util.tools;
import buaa.group6.litcenter.model.Literature;
import buaa.group6.litcenter.service.HttpClient;
import buaa.group6.litcenter.service.LITService;
import buaa.group6.litcenter.service.mongoRepository.LITRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@CrossOrigin
public class LITController {
    @Autowired
    LITService litService;
    @Autowired
    LITRepository litRepository;
    @Autowired
    HttpClient httpClient;

    @ResponseBody
    @RequestMapping(value = "getLITs", method = RequestMethod.GET)
    public List<Literature> getLITs(@RequestParam String type, String sortType, String params){
        tools sortTool = new tools();
        if(type == "title")
            return litService.getLITByTitle(params);
            //排序
            //return sortTool.LITSort(sortType,litService.getLITByTitle(params));
        else if (type == "titleContaining")
            return litService.getLITByTitleContaining(params);
            //排序
            //return sortTool.LITSort(sortType,litService.getLITByTitleContaining(params));
        else if(type == "author")
            return litService.getLITByAuthor(params);
            //排序
            //return sortTool.LITSort(sortType,litService.getLITByAuthor(params));
        else
            return null;
    }

    @RequestMapping(value = "getLIT", method = RequestMethod.GET)
    public Literature getLIT(@RequestParam String id){
        return litService.getLITByID(id);
    }
}
