package org.benbox.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringController {
    public static void main(String[] args) {
        SpringApplication.run(SpringController.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", required = false, defaultValue = "Benjamin") String name, Model model) {
        model.addAttribute("name", name);
        return String.format("Hallo %s!", name);
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
