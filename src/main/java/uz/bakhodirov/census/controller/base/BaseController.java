package uz.bakhodirov.census.controller.base;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @GetMapping("/")
    public String home(){
        return "home";
    }
}
