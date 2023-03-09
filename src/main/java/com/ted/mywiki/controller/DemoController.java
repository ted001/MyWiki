package com.ted.mywiki.controller;

import com.ted.mywiki.domain.Demo;
import com.ted.mywiki.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Resource
    private DemoService demoService;

    @GetMapping("/list2")
    public List<Demo> list() {
        return demoService.list();
    }
}
