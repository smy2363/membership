package com.membership.Control;

import com.membership.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class MainControl {




    @GetMapping("/")
    public String home(){

        return "/index";
    }
}
