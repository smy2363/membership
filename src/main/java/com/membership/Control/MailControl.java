package com.membership.Control;

import com.membership.Dto.MailDto;
import com.membership.Service.FindIdService;
import com.membership.Service.FindPwService;
import com.membership.Service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MailControl {
    private final MailService mailService;
    private final FindIdService findIdService;
    private final FindPwService findPwService;

    @ResponseBody
    @PostMapping("/mail")
    public String MailSend(String mail){
        int number = mailService.sendMail(mail);
        String num = "" + number;
        return num;
    }


    @PostMapping("/findId")
    public String findId(String email){
        System.out.println(email);
        findIdService.sendMail(email);
        return "redirect:/member/signIn";
    }


    // 비밀번호 찾기시, 임시 비밀번호 담긴 이메일 보내기
    @Transactional
    @PostMapping("/findPw")
    public String sendEmail(@RequestParam("email") String memberEmail) {
        MailDto dto = findPwService.createMailAndChangePassword(memberEmail);
        findPwService.mailSend(dto);

        return "redirect:/member/signIn";
    }
}
