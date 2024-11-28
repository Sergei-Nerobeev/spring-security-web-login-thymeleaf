package hu.nero.spring_security_web_login_thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {

  @GetMapping("/home")
  public String handleWelcome() {
    return "home";
  }

  @GetMapping("/admin/home")
  public String handleAdminHome() {
    return "home_admin";
  }

  @GetMapping("/user/home")
  public String handleUserHome() {
    return "home_user";
  }

  @GetMapping("/login")
  public String handleLogin() {
    return "login";
  }

}
