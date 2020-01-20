package com.example.demo.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexController {
    @GetMapping("/index")
    fun index(model: Model) : String{
            model["name"] = "Daejun"
        return "index"
    }
}