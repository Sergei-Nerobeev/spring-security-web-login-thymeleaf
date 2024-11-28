package hu.nero.spring_security_web_login_thymeleaf.controller;

import hu.nero.spring_security_web_login_thymeleaf.model.MyUser;
import hu.nero.spring_security_web_login_thymeleaf.repo.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegistrationController {

  private final MyUserRepository myUserRepository;
  private final PasswordEncoder passwordEncoder;

  @Autowired
  public RegistrationController(MyUserRepository myUserRepository, PasswordEncoder passwordEncoder) {
    this.myUserRepository = myUserRepository;
    this.passwordEncoder = passwordEncoder;
  }

//  @PostMapping("/register/user")
//  public MyUser createUser(@RequestBody MyUser user) {
//    user.setPassword(passwordEncoder.encode(user.getPassword()));
//
//    return myUserRepository.save(user);
//  }

  @PostMapping("/register/user")
  public String createUser(@RequestBody MyUser user, RedirectAttributes redirectAttributes) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    myUserRepository.save(user);
    redirectAttributes.addAttribute("message", "User successfully registered!");
    return "home_user";
  }
  @PostMapping("/register/admin")
  public String createAdmin(@RequestBody MyUser user, RedirectAttributes redirectAttributes) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    myUserRepository.save(user);
    redirectAttributes.addAttribute("message", "User successfully registered!");
    return "home_admin";
  }


}
