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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;

/**
 * PageController handles HTTP requests for serving various web pages.
 */
@Controller
public class PageController {
    private static final Logger logger = LoggerFactory.getLogger(PageController.class);

    /**
     * Redirects to the index page.
     * 
     * @return a redirect to the index page
     */
    @GetMapping("/")
    public String home() {
        return "redirect:/index";  // Use redirect to ensure any security context is passed correctly
    }

    /**
     * Handles requests to dynamically serve pages based on the URL path.
     * 
     * @param page the page name extracted from the URL path
     * @param model the Model object to pass data to the view
     * @return the view name to render or an error view if the page is not found
     */
    @RequestMapping("/{page}")
    public String handlePage(@PathVariable("page") String page, Model model) {
        try {
            Method method = this.getClass().getDeclaredMethod(page, Model.class);
            if (method != null) {
                return (String) method.invoke(this, model);
            }
        } catch (NoSuchMethodException e) {
            // Method not found, show 404
            model.addAttribute("error", "Page not found");
            model.addAttribute("message", "The page you are looking for might have been removed, had its name changed, or is temporarily unavailable.");
            return "404";
        } catch (Exception e) {
            // Some other error occurred, show generic error page
            model.addAttribute("error", "An unexpected error occurred");
            model.addAttribute("message", e.getMessage());
            return "error";
        }
        return "404";
    }

    /**
     * Serves the index page for authenticated users.
     * 
     * @param model the Model object to pass data to the view
     * @return the view name to render
     */
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

    /**
     * Serves the error page.
     * 
     * @return the view name to render
     */
    @GetMapping("/error")
    public String error() {
        return "404";
    }

    @GetMapping("/header")
    public String header() {
        return "header";
    }

    @GetMapping("/footer")
    public String footer() {
        return "footer";
    }

    @GetMapping("/business-signup")
    public String businessSignup() {
        return "signup_business";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/categories")
    public String categories() {
        return "viewCategory";
    }

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

    @GetMapping("/adminDelete")
    public String adminDelete() {
        return "adminDelete";
    }

    @GetMapping("/adminEditUniversity")
    public String adminEditUniversity() {
        return "adminEditUniversity";
    }

    @GetMapping("/adminEditCulture")
    public String adminEditCulture() {
        return "adminEditCulture";
    }

    @GetMapping("/adminEditCategory")
    public String adminEditCategory() {
        return "adminEditCategory";
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

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/ownerHeader")
    public String ownerHeader() {
        return "ownerHeader";
    }

    @GetMapping("/ownerDashboard")
    public String ownerDashboard() {
        return "ownerDashboard";
    }

    @GetMapping("/ownerBusinesses")
    public String ownerBusinesses() {
        return "ownerBusinesses";
    }

    @GetMapping("/ownerEditBusiness")
    public String ownerEditBusiness() {
        return "ownerEditBusiness";
    }

    @GetMapping("/ownerEvents")
    public String ownerEvents() {
        return "ownerEvents";
    }

    @GetMapping("/ownerProducts")
    public String ownerProducts() {
        return "ownerProducts";
    }

    @GetMapping("/ownerDelete")
    public String ownerDelete() {
        return "ownerDelete";
    }
}
