package hoangquochthai.chatapp.controller;

import hoangquochthai.chatapp.dto.requestDTO.GroupChatRequestDTO;
import hoangquochthai.chatapp.entity.GroupChat;
import hoangquochthai.chatapp.entity.Message;
import hoangquochthai.chatapp.entity.User;
import hoangquochthai.chatapp.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class GroupController {
    @Autowired
    GroupService groupService;

    @GetMapping("/")
    public List<GroupChat> getAllGroupOfUser(@RequestBody User user){
        return groupService.getAllGroupOfUser(user);
    }

    @PostMapping("/create-group")
    public GroupChat createGroup(@RequestBody GroupChatRequestDTO groupChatRequestDTO){
        return groupService.createGroup(groupChatRequestDTO);
    }

    @GetMapping("/get-messages")
    public List<Message> loadMessageOfGroup(GroupChat groupChat){
        return groupService.loadMessageOfGroup(groupChat);
    }
}
