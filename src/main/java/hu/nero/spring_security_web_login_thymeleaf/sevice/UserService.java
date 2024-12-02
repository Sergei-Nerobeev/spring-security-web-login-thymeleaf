package hu.nero.spring_security_web_login_thymeleaf.sevice;

import hu.nero.spring_security_web_login_thymeleaf.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

  private static List<UserModel> users;

  static {
    users = new ArrayList<>();
    users.add(new UserModel(1,"Joe","1234"));
    users.add(new UserModel(2,"Ann","1234"));
    users.add(new UserModel(3,"Ted","1234"));
    users.add(new UserModel(4,"Nora","1234"));
  }

  public List<UserModel> getAllUsersByLogin(String login) {
    if(login != null) {
      return users;
    }
    return users.stream().filter(user -> user.getId() > 2).toList();
  }
}
