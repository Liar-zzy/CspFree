package com.ccf.controller;


import com.ccf.service.RedListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/RedList")
public class RedListController {

    @Autowired
    private RedListService redListService;

    @RequestMapping("insertIntoRedList")
    @ResponseBody
    public Map<String, String> insertIntoRedList(HttpRequest httpRequest){

        Map<String, String> map = new HashMap<>();

        return map;
    }

}
