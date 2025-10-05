package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WebController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public WebController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(User user, RedirectAttributes redirectAttributes) { // เพิ่ม RedirectAttributes
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        // เพิ่มข้อความที่จะแสดงผลในหน้าถัดไป
        redirectAttributes.addFlashAttribute("successMessage", "Registration successful! You can now log in.");
        return "redirect:/login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
