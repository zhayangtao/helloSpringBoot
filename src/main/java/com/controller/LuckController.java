package com.controller;

import com.entity.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shliangyan on 2017/11/22.
 */
@RestController
@EnableConfigurationProperties
public class LuckController {
    @Autowired
    ConfigBean configBean;

    @RequestMapping(value = "/luck")
    public String miya() {
        return configBean.getGreeting() + ">>>" + configBean.getName() + ">>>";
    }
}
