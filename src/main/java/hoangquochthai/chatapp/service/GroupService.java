package hoangquochthai.chatapp.service;

import hoangquochthai.chatapp.dto.requestDTO.GroupChatRequestDTO;
import hoangquochthai.chatapp.dto.MessageDTO;
import hoangquochthai.chatapp.dto.requestDTO.UserRequestDTO;
import hoangquochthai.chatapp.dto.responseDTO.UserResponseDTO;
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

import java.util.ArrayList;
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


    public List<GroupChat> getAllGroupOfUser(String username) {
//        User user = (userRepository.findById("user8").get());
//        GroupChat groupChat = (groupChatRepository.findById(38l)).get();
//        GroupUserId groupUserId = new GroupUserId();
//        groupUserId.setUser(user);
//        groupUserId.setGroupChat((groupChat));
//
//        groupUserRepository.deleteById(groupUserId);
//        groupChatRepository.deleteById(38l);

//        List<Group>
        List<GroupChat> list = groupUserRepository.findAllByUser(username);
        return list;
    }

    public GroupChat createGroup(GroupChatRequestDTO groupChatRequestDTO) {
        Optional<User> user = userRepository.findById(groupChatRequestDTO.getUsername());

        GroupChat groupChat = GroupChat.builder()
                .creator(user.get())
                .groupName(groupChatRequestDTO.getRoomName())
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

    public List<MessageDTO> loadMessageOfGroup(Long groupId) {
        List<GroupUser> groupUsers = groupUserRepository.findAllByGroupChat(groupId);
        List<Message> messages = messageRepository.findAllByGroupChat(groupId);
        List<MessageDTO> messageResponseDTOS = new ArrayList<>();
        for (GroupUser groupUser : groupUsers) {
            for (Message message : messages)
                if (groupUser.getUser().getUsername().equals(message.getSender().getUsername())) {
                    messageResponseDTOS.add(new MessageDTO(new UserResponseDTO(groupUser.getUser().getUsername(), groupUser.getUser().getFullName(), groupUser.getUser().getUserAvatar()),message));
                }
        }

        return messageResponseDTOS;
    }
}