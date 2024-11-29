package hu.nero.spring_security_web_login_thymeleaf.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @GetMapping
    public String getWeatherPage(@RequestParam(required = false, name = "login")String login,
                              @RequestParam(required = false)String email,
                              Model model) {
        model.addAttribute("userLogin", login);
        return "weather_page";
    }

}

