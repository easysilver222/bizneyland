package com.bizns.bizneyland.web.controller;

import com.bizns.bizneyland.service.CompanyService;
import com.bizns.bizneyland.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final CompanyService companyService;
    private final MemberService memberService;

    @GetMapping("/")
    public String index(Model model) {
        return "main";
    }

    @GetMapping("/member")
    public String member(Model model) {
        model.addAttribute("members", memberService.findAllDesc());
        return "member/member";
    }

    @GetMapping("/company")
    public String company(Model model) {
        model.addAttribute("companies", companyService.findAllDesc());
        return "company/company";
    }
}
