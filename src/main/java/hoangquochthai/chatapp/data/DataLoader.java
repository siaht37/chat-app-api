package hoangquochthai.chatapp.data;//package hoangquochthai.chatapp.data;
//import hoangquochthai.chatapp.dto.requestDTO.UserRequestDTO;
//import hoangquochthai.chatapp.repository.FriendRepository;
//import hoangquochthai.chatapp.repository.UserRepository;
//import hoangquochthai.chatapp.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DataLoader implements CommandLineRunner {
//    @Autowired
//    private UserService userService;
//    @Autowired
//    UserRepository userRepository;
//    @Autowired
//    FriendRepository friendRepository;
//
//
//    @Override
//    public void run(String... args) throws Exception {
//        // Tạo 10 người dùng khi ứng dụng khởi chạy
//        for (int i = 0; i < 10; i++) {
//            String username = "user" + i;
//            if (!userRepository.existsById(username)) { // Kiểm tra xem người dùng đã tồn tại chưa
//                UserRequestDTO user = new UserRequestDTO();
//                user.setUsername(username);
//                user.setPassword("password" + i);
//                user.setFullName("User " + i);
//                userService.register(user);
//            }
//        }
////        List<User> users= userService.getAll();
////        for(int i = 0; i < 5; i++){
////            Friend friend = Friend.builder()
////                    .user(users.get(i))
////                    .friendOfUser(users.get(i+1))
////                    .build();
////            friendRepository.save(friend);
////        }
//
////        Friend friendship1 = Friend.builder()
////                .user(users.get(0))
////                .friendOfUser(users.get(1))
////                .build();
////        Friend friendship2 = Friend.builder()
////                .user(users.get(1))
////                .friendOfUser(users.get(0))
////                .build();
////        friendRepository.save(friendship1);
////        friendRepository.save(friendship2);
//
//    }
//}
//


//
//import hoangquochthai.chatapp.repository.MessageRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DataLoader implements CommandLineRunner {
//
//    @Autowired
//    private MessageRepository messageRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        messageRepository.deleteAll();
//    }
//}