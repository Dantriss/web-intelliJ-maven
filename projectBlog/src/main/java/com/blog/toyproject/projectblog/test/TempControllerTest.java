package com.blog.toyproject.projectblog.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class TempControllerTest {

    @GetMapping("/jsp")
    public String tempJsp() {
        log.info("jsp");
        return "test";
    }
}
