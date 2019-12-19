package com.ccf.controller;


import com.ccf.service.FreeListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/FreeList")
public class FreeListController {

    @Autowired
    private FreeListService freeListService;


}
