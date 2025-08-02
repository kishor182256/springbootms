package com.spring.SpringBootApp.controller;

import com.spring.SpringBootApp.config.AppBuildInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuildInfoController {

    @Autowired
    private AppBuildInfo appBuildInfo;

    @GetMapping("/build-info")
    public String BuildInfo() {
        return "Build Info: "+
                 appBuildInfo.getId()+
                "Build ID: " + appBuildInfo.getVersion() + "\n" +
                "Build Name: " + appBuildInfo.getName() ;
    }


}
