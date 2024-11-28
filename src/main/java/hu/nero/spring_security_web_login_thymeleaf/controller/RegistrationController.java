package hu.nero.spring_security_web_login_thymeleaf.controller;

import hu.nero.spring_security_web_login_thymeleaf.model.MyUser;
import hu.nero.spring_security_web_login_thymeleaf.repo.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
  @Autowired
  private MyUserRepository myUserRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;

  @PostMapping("/register/user")
  public MyUser createUser(@RequestBody MyUser user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return myUserRepository.save(user);
  }
}
