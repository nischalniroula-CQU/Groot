package com.fyp.groot.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;


@Controller
public class PageController {
    private static final Logger logger = LoggerFactory.getLogger(PageController.class);

    @GetMapping("/")
    public String home() {
        return "redirect:/index";  // Use redirect to ensure any security context is passed correctly
    }
	
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/index")
    public String index(Model model) {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            model.addAttribute("username", userDetails.getUsername());
        }
        return "index";
    }
    
    @GetMapping("/header")
    public String header() {
        return "header";
    }
    
    @GetMapping("/footer")
    public String footer() {
        return "footer";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    // to view the business listing by category
    @GetMapping("/categories")
    public String categories() {
        return "viewCategory";
    }
    
    // to view the business listing individually
    @GetMapping("/business")
    public String business() {
        return "business";
    }
    
    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }
    
    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }
    
    @GetMapping("/adminHeader")
    public String adminHeader() {
        return "adminHeader";
    }
    
    @GetMapping("/adminDashboard")
    public String adminDashboard() {
        return "adminDashboard";
    }
    
    @GetMapping("/addBusiness")
    public String addBusiness() {
        return "addBusiness";
    }
    
    @GetMapping("/addEvent")
    public String addEvent() {
        return "addEvent";
    }
    
    @GetMapping("/addProduct")
    public String addProduct() {
        return "addProduct";
    }
    
    @GetMapping("/adminBusinesses")
    public String adminBusinesses() {
        return "adminBusinesses";
    }
    
    @GetMapping("/adminEvents")
    public String adminEvents() {
        return "adminEvents";
    }
    
    @GetMapping("/adminProducts")
    public String adminProducts() {
        return "adminProducts";
    }
    
    @GetMapping("/adminUsers")
    public String adminUsers() {
        return "adminUsers";
    }
    
    @GetMapping("/adminTerms")
    public String adminTerms() {
        return "adminTerms";
    }
    
    @GetMapping("/adminCategories")
    public String adminCategories() {
        return "adminCategories";
    }
    
    @GetMapping("/adminAddCategory")
    public String adminAddCategory() {
        return "adminAddCategory";
    }
    
    @GetMapping("/adminCultures")
    public String adminCultures() {
        return "adminCultures";
    }
    
    @GetMapping("/adminAddCulture")
    public String adminAddCulture() {
        return "adminAddCulture";
    }
    
    @GetMapping("/adminUniversities")
    public String adminUniversities() {
        return "adminUniversities";
    }
    
    @GetMapping("/adminAddUniversity")
    public String adminAddUniversity() {
        return "adminAddUniversity";
    }
    
    @GetMapping("/adminInterests")
    public String adminInterests() {
        return "adminInterests";
    }
    
    @GetMapping("/adminAddInterest")
    public String adminAddInterest() {
        return "adminAddInterest";
    }
    
    @GetMapping("/adminTags")
    public String adminTags() {
        return "adminTags";
    }
    
    @GetMapping("/adminAddTag")
    public String adminAddTag() {
        return "adminAddTag";
    }
}
