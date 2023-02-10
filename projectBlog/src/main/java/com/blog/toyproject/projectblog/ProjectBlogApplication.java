package com.blog.toyproject.projectblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//@SpringBootApplication(scanBasePackages = {"com.blog.repository"})
@SpringBootApplication


@EntityScan(basePackages = {"com.blog.table"})
@EnableJpaRepositories(basePackages = {"com.blog.repository"})
public class ProjectBlogApplication {


    public static void main(String[] args) {
        SpringApplication.run(ProjectBlogApplication.class, args);
    }



}
