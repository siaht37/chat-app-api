package hoangquochthai.chatapp.controller;

import hoangquochthai.chatapp.dto.requestDTO.UserRequestDTO;
import hoangquochthai.chatapp.entity.User;
import hoangquochthai.chatapp.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> getAll(){

        List<User> users = new ArrayList<>();
        for (User user : userService.getAll()) {
            user.setUserAvatar("https://picsum.photos/200");
            users.add(user);
        }
        return users;
    }

    @PostMapping("/register")
    public User register(@RequestBody UserRequestDTO userRequestDTO) {
        return userService.register(userRequestDTO);
    }

    @PostMapping("/login")
    public User login(@RequestBody UserRequestDTO userRequestDTO, HttpServletRequest request) {
        return userService.login(userRequestDTO.getUsername(), userRequestDTO.getPassword(), request);
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