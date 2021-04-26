package com.arthur.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @title: FileHandleConfig
 * @Author ArthurJi
 * @Date: 2021/4/26 20:44
 * @Version 1.0
 * 设置之后  可以在打包成jar之后 读取到jar同一目录下的文件
 */
@Configuration
public class FileHandleConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("file:" +System.getProperty("user.dir")+"\\");
        super.addResourceHandlers(registry);
    }

}