package examples.boot.springboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
public class MainController {

    public MainController(){
        System.out.println("MainController()!");
    }
    @RequestMapping("/")  // /에 대한 요청을 처리 해준다.
    public String main(){
        return "index"; // view name을 리턴, indext.jsp로 forward해준다
    }
}