package com.fyp.groot.controller;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fyp.groot.entity.User;
import com.fyp.groot.service.UserService;

/**
 * UserController handles HTTP requests for user-related operations.
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Handles GET requests to get user information by Firebase UID.
     * 
     * @param id the Firebase UID of the user to retrieve
     * @return the user information
     * @throws InterruptedException if the operation is interrupted
     * @throws ExecutionException if an execution error occurs
     */
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id) throws InterruptedException, ExecutionException {
        return userService.getUserMeta(id);
    }

    /**
     * Handles GET requests to get user information by entity user ID.
     * 
     * @param id the entity user ID of the user to retrieve
     * @return a ResponseEntity containing the user information or NOT_FOUND status if the user is not found
     * @throws InterruptedException if the operation is interrupted
     * @throws ExecutionException if an execution error occurs
     */
    @GetMapping("/user/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) throws InterruptedException, ExecutionException {
        Optional<User> user = userService.getUserByUserId(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Handles DELETE requests to delete a user by Firebase UID.
     * 
     * @param id the Firebase UID of the user to delete
     * @return a confirmation message
     * @throws InterruptedException if the operation is interrupted
     * @throws ExecutionException if an execution error occurs
     */
    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable String id) throws InterruptedException, ExecutionException {
        return userService.deleteUser(id);
    }

    /**
     * Handles GET requests to get all users.
     * 
     * @return a list of all users
     * @throws InterruptedException if the operation is interrupted
     * @throws ExecutionException if an execution error occurs
     */
    @GetMapping("/allUser")
    public List<User> getAllUser() throws InterruptedException, ExecutionException {
        return userService.getAllUserDetails();
    }
}
