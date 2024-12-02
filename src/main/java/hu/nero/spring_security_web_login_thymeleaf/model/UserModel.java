package hu.nero.spring_security_web_login_thymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

  private int id;
  private String name;
  private String password;
}
