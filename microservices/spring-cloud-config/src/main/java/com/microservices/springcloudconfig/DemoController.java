package com.microservices.springcloudconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private DbConnection dbConnection;

    @Autowired
    private Environment environment;

    @GetMapping("/demo")
    public String demo(){
        return dbConnection.getConnection() +" "+ dbConnection.getPort();
    }

    @GetMapping("/envdetails")
    public String getEnvDetails(){
        return environment.toString();
    }
}
