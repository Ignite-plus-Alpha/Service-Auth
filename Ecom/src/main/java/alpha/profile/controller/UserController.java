package alpha.profile.controller;

import alpha.profile.model.User;
import alpha.profile.services.UserService;
import alpha.profile.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> getAllUser() {
        return userService.getAllUser();

    }

    @GetMapping("/user/{userId}")
    public Optional<User> getUserById(@PathVariable("userId") String userId) {
        try {
            return userService.getUserById(userId);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());

        }
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);

    }

    @DeleteMapping("/user/{userId}")
    public void deleteUserById(@PathVariable("userId") String userId) throws UserNotFoundException {
        userService.deleteUserById(userId);
    }


    @PutMapping("/user/{userId}")
    public User updateUserById(@PathVariable("userId") String userId,@RequestBody String newName) {
        try {
            return userService.updateUserById(userId, newName);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

}