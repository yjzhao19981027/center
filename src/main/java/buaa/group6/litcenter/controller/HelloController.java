package buaa.group6.litcenter.controller;

import buaa.group6.litcenter.service.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;

public class HelloController {
    @Autowired
    HttpClient httpClient;

    @RequestMapping(value = "/hellos")
    public String hello(){
        String url = "";
        HttpMethod method = HttpMethod.GET;
        MultiValueMap<String,String> param = new LinkedMultiValueMap<>();
        return httpClient.client(url,method,param);
    }
}
