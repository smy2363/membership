package com.membership.Control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberControl {

    @GetMapping("/login")
    public String login(Model model){
        return "/member/login";
    }
}
