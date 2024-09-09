package com.membership.Control;

import com.membership.Service.FindIdService;
import com.membership.Service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MailControl {
    private final MailService mailService;
    private final FindIdService findIdService;

    @ResponseBody
    @PostMapping("/mail")
    public String MailSend(String mail){
        int number = mailService.sendMail(mail);
        String num = "" + number;
        return num;
    }


    @PostMapping("/findId")
    public @ResponseBody ResponseEntity findId(String email){
        System.out.println(email);
        findIdService.sendMail(email);
        return new ResponseEntity<Integer>(0, HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping("/findPw")
    public String findPw(String mail){
        System.out.println("wwwwwwwwwwww"+mail);
        int number = mailService.sendMail(mail);
        String num = "" + number;
        return num;
    }
}
