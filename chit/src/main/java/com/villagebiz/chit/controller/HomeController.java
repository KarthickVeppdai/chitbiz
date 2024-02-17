package com.villagebiz.chit.controller;

import com.villagebiz.chit.model.Member;
import com.villagebiz.chit.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/homepage")
    public String homepage()
    {
        return "pages/homedashboard";
    }
    @GetMapping("/addchit")
    public String addchit()
    {
        return "pages/addnewchit";
    }

    @GetMapping("/assign")
    public String assign()
    {
        return "pages/assignmembers";
    }

    @GetMapping("/addmember")
    public String addmember(Model model)
    {
        model.addAttribute("member", new Member());
        model.addAttribute("memberlist",memberService.getAllMembers());
        return "pages/addmember";
    }

    @GetMapping("/profile")
    public String profile()
    {
        return "pages/profile";
    }
    @GetMapping("/changepassword")
    public String changepassword()
    {
        return "pages/changepassword";
    }

    @GetMapping("/chithome")
    public String login()
    {
        BCryptPasswordEncoder bCryptPasswordEncoder =new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("test"));
        return "pages/loginpage";
    }

    SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();

    @GetMapping("/logout")
    public String performLogout(Authentication authentication, HttpServletRequest request, HttpServletResponse response) {
        this.logoutHandler.logout(request,response,authentication);
        return "redirect:/login";
    }

    @PostMapping("/savemember")
    public String profileUpdate1(final @Valid Member member, final BindingResult bindingResult,
                                 final Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.member",bindingResult);
            redirectAttributes.addFlashAttribute("uProfile", member);
            return "pages/addmember";

        }
        else
        {

            System.out.println(member);
            memberService.saveMember(member);
            redirectAttributes.addFlashAttribute("message","Member Saved Sucessfully");
            redirectAttributes.addFlashAttribute("uProfile", new Member());
            redirectAttributes.addFlashAttribute("memberlist",memberService.getAllMembers());
            return "redirect:/home/addmember";
        }
    }
}
