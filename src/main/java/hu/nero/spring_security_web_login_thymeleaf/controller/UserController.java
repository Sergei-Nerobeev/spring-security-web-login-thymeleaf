package hu.nero.spring_security_web_login_thymeleaf.controller;

import hu.nero.spring_security_web_login_thymeleaf.model.UserModel;
import hu.nero.spring_security_web_login_thymeleaf.sevice.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  public static final String USER_LOGIN = "userLogin";
  private final UserService userService;

  @GetMapping
  public String getUserPage(
      @RequestParam(required = false, name = "login") String login,
      @RequestParam(required = false) String email,
      Model model, HttpServletRequest request) {

    HttpSession session = request.getSession();
    if (login != null && !login.isEmpty()) {
      session.setAttribute(USER_LOGIN, login);
    }
    String userLogin = (String) session.getAttribute(USER_LOGIN);

    model.addAttribute(USER_LOGIN, userLogin);

    List<UserModel> users = userService.getAllUsersByLogin(login);
    model.addAttribute("users", users);
    return "user_page";
  }

  @GetMapping("/create")
  public String getCreateUserPage(Model model) {
    model.addAttribute("newUser", new UserModel());
    return "create_user_page";
  }

  @PostMapping("/createUser")
  public String createUser(@ModelAttribute UserModel user) {
    userService.save(user);
    return "redirect:/users";
  }
}

