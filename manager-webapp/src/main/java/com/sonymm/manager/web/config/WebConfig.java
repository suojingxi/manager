package com.sonymm.manager.web.config;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author suojx(1466200463@qq.com)
 * @Date 2016/12/17 2:17
 */
@Configuration
@ServletComponentScan("com.sonymm.manager.web.filter")
public class WebConfig {
}
