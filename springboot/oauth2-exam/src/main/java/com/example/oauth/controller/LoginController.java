package com.example.oauth.controller;

import com.example.oauth.annotation.SocialUser;
import com.example.oauth.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/{facebook|google|kakao}/complete")
    public String loginComplete(@SocialUser User user) {
        return "redirect:/board/list";
    }

//    @GetMapping(value = "/{facebook|google|kakao}/complete")
//    public String loginComplete(HttpSession session) {
//        OAuth2Authentication auth2Authentication =
//                (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
//        Map<String, String> map = (HashMap<String, String>)
//                auth2Authentication.getUserAuthentication().getDetails();
//
//        session.setAttribute("user", User.builder()
//                .name(map.get("name"))
//                .email(map.get("email"))
//                .principal(map.get("id"))
//                .socialType(SocialType.GOOGLE)
//                .createdDate(LocalDateTime.now())
//                .build()
//        );
//
//        return "redirect:/board/list";
//    }
}