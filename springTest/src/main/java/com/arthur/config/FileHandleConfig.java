package com.arthur.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.File;

/**
 * @title: FileHandleConfig
 * @Author ArthurJi
 * @Date: 2021/4/26 20:44
 * @Version 1.0
 * 设置之后  可以在打包成jar之后 读取到jar同一目录下的文件
 */
@Configuration
class FileHandleConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String dir = System.getProperty("user.dir");

        //System.out.println("项目当前路径："+dir);
        //构建路径
        File file=new File(dir+ File.separatorChar+"ImageData");
        if(!file.exists()){
            file.mkdir();
        }
        String resourceLocation=file.getAbsolutePath()+File.separatorChar;
        //System.out.println(resourceLocation+">>>>>>");

        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources/")
                .addResourceLocations("classpath:/resources/")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/public/")
                .addResourceLocations("file:"+resourceLocation);
        super.addResourceHandlers(registry);
    }
}
