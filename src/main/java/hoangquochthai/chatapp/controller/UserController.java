package hoangquochthai.chatapp.controller;

import hoangquochthai.chatapp.dto.requestDTO.UserRequestDTO;
import hoangquochthai.chatapp.entity.User;
import hoangquochthai.chatapp.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> getAll(){
        return userService.getAll();
    }

    @PostMapping("/register")
    public User register(@RequestBody UserRequestDTO userRequestDTO) {
        return userService.register(userRequestDTO);
    }

    @PostMapping("/login")
    public User login(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
        return userService.login(username, password, request);
    }

    @GetMapping("/friends")
    public List<User> getAllFriends(HttpServletRequest request) {
        return userService.getAllFriends(request);
    }

    @PostMapping("/add-friend/{username}")
    public void addFriend(HttpServletRequest request, @PathVariable String username) {
        userService.addFriend(request, username);
    }
}