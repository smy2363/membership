package com.membership.Control;

import com.membership.Dto.MemberForm;
import com.membership.Service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/member")
public class MemberControl {

    //메인페이지
    @GetMapping("/login")
    public String login(Model model){
        return "/member/login";
    }
    // 아이디찾기
    @GetMapping("/findId")
    public String findId(Model model){
        return "member/findId";
    }
    // 비밀번호 찾기
    @GetMapping("/findPw")
    public String findPw(Model model){
        return "member/findPw";
    }
    //회원가입 페이지
    @GetMapping("/signUp")
    public String signUp(Model model){
        model.addAttribute("memberForm",new MemberForm());
        return "member/signUp";
    }

    // 회원가입 요청
    @PostMapping("/signUp")
    public String join(@Valid MemberForm memberForm,
                       BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors() ){ //유효하지 않은 값 존재
            return "member/join";
        }
        try {
            MemberService.saveMember(memberForm, passwordEncoder);
        }catch(IllegalStateException e1){
            bindingResult.rejectValue("userId","error.userId", e1.getMessage());
            return "member/join";
        }catch(IllegalArgumentException e2){
            bindingResult.rejectValue("email","error.memberForm", e2.getMessage());
            return "member/join";
        }

        return "redirect:/member/signIn";

    }

    // 로그인 실패 - 아이디나 비밀번호 틀린경우
    @GetMapping("/signIn/error")
    public String loginFail(Model model){
        model.addAttribute("loginFailMsg","아이디 또는 비밀번호가 올바르지 않습니다.");
        return "member/login";
    }

}