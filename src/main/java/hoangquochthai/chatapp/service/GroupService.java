package hoangquochthai.chatapp.service;

import hoangquochthai.chatapp.dto.requestDTO.GroupChatRequestDTO;
import hoangquochthai.chatapp.dto.responseDTO.GroupChatResponseDTO;
import hoangquochthai.chatapp.entity.GroupChat;
import hoangquochthai.chatapp.entity.GroupUser;
import hoangquochthai.chatapp.entity.User;
import hoangquochthai.chatapp.repository.GroupChatRepository;
import hoangquochthai.chatapp.repository.GroupUserRepository;
import hoangquochthai.chatapp.repository.MessageRepository;
import hoangquochthai.chatapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    @Autowired
    GroupChatRepository groupChatRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    GroupUserRepository groupUserRepository;
    @Autowired
    MessageRepository messageRepository;

    public List<GroupChat> getAllGroupOfUser(User user){
        return groupChatRepository.findAllByCreator(user);
    }
    public GroupChat createGroup(GroupChatRequestDTO groupChatRequestDTO){
        Optional<User> user = userRepository.findById(groupChatRequestDTO.getUsername());

        GroupChat groupChat = GroupChat.builder()
                .creator(user.get())
                .build();

        for (User userr: groupChatRequestDTO.getUsers()) {
            groupUserRepository.save(GroupUser.builder()
                            .user(userr)
                            .groupChat(groupChat)
                    .build());
        }

        return groupChat;
    }
}
