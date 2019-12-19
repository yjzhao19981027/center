package buaa.group6.litcenter.controller;

import buaa.group6.litcenter.container.autoGenerate;
import buaa.group6.litcenter.util.tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BothController {
    @Autowired
    tools Tool = new tools();

    @ResponseBody
    @RequestMapping(value = "getBoth", method = RequestMethod.GET)
    public autoGenerate getBoth(@RequestParam String params){
        return Tool.getBoth(params);
    }
}
