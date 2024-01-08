package hoangquochthai.chatapp.service;

import hoangquochthai.chatapp.dto.requestDTO.UserRequestDTO;
import hoangquochthai.chatapp.entity.Friend;
import hoangquochthai.chatapp.entity.User;
import hoangquochthai.chatapp.repository.FriendRepository;
import hoangquochthai.chatapp.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    FriendRepository friendRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User register(UserRequestDTO userRequestDTO) {
        // Kiểm tra xem người dùng đã tồn tại chưa
        if (userRepository.existsById(userRequestDTO.getUsername())) {
            throw new RuntimeException("Username already exists: " + userRequestDTO.getUsername());
        }
        User user = User.builder()
                .username(userRequestDTO.getUsername())
                .password(userRequestDTO.getPassword())
                .fullName(userRequestDTO.getFullName())
                .userAvatar(null)
                .createdAt(new Date())
                .build();
        // Lưu người dùng mới vào cơ sở dữ liệu
        return userRepository.save(user);
    }

    public User login(String username, String password, HttpServletRequest request) {
        // Tìm người dùng trong cơ sở dữ liệu bằng username
        User user = userRepository.findById(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));

        // Kiểm tra mật khẩu
        if (!password.equals(user.getPassword())) {
            throw new RuntimeException("Invalid password for username: " + username);
        }

        // Tạo session cho người dùng sau khi đăng nhập thành công
        HttpSession session = request.getSession(true);
        session.setAttribute("loggedInUser", user); // Lưu thông tin người dùng vào session

        // Trả về User nếu đăng nhập thành công
        return user;
    }

    public List<User> getAllFriends (HttpServletRequest request){
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("loggedInUser") == null) {
            throw new RuntimeException("User is not logged in");
        }

        User loggedInUser = (User) session.getAttribute("loggedInUser");

        List<User> friends = friendRepository.findAllFriendsByUser(loggedInUser.getUsername());
        return friends;
    }

    public void addFriend(HttpServletRequest request, String username) {
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("loggedInUser") == null) {
            throw new RuntimeException("User is not logged in");
        }

        User loggedInUser = (User) session.getAttribute("loggedInUser");
        User friendUser = userRepository.findById(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));

        Friend friendship1 = Friend.builder()
                .user(loggedInUser)
                .friendOfUser(friendUser)
                .build();
        Friend friendship2 = Friend.builder()
                .user(friendUser)
                .friendOfUser(loggedInUser)
                .build();
        friendRepository.save(friendship1);
        friendRepository.save(friendship2);
    }


}
