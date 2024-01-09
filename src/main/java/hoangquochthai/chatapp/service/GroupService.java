package hoangquochthai.chatapp.service;

import hoangquochthai.chatapp.dto.requestDTO.GroupChatRequestDTO;
import hoangquochthai.chatapp.dto.responseDTO.GroupChatResponseDTO;
import hoangquochthai.chatapp.entity.GroupChat;
import hoangquochthai.chatapp.entity.GroupUser;
import hoangquochthai.chatapp.entity.Message;
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

    public List<GroupChat> getAllGroupOfUser(String username){
        Optional<User> user = userRepository.findById(username);
        return groupChatRepository.findAllByCreator(user.get());
    }
    public GroupChat createGroup(GroupChatRequestDTO groupChatRequestDTO) {
        Optional<User> user = userRepository.findById(groupChatRequestDTO.getUsername());

        GroupChat groupChat = GroupChat.builder()
                .creator(user.get())
                .build();

        GroupChat groupChatSaved = groupChatRepository.save(groupChat);

        for (String string : groupChatRequestDTO.getUsers()) {

            Optional<User> userOptional = userRepository.findById(string);

            GroupUser groupUser = new GroupUser();
            groupUser.setUser(userOptional.get());
            groupUser.setGroupChat(groupChatSaved);
            groupUserRepository.save(groupUser);
        }
        return groupChat;
    }

    public List<Message> loadMessageOfGroup (Long userId) {
        Optional<GroupChat> loadMessage = groupChatRepository.findById(userId);

        return messageRepository.findAllByGroupChat(loadMessage.get());
    }
}