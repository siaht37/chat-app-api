package hoangquochthai.chatapp.controller;

import hoangquochthai.chatapp.dto.requestDTO.GroupChatRequestDTO;
import hoangquochthai.chatapp.entity.GroupChat;
import hoangquochthai.chatapp.entity.Message;
import hoangquochthai.chatapp.entity.User;
import hoangquochthai.chatapp.repository.GroupChatRepository;
import hoangquochthai.chatapp.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class GroupController {
    @Autowired
    GroupService groupService;
    @Autowired
    GroupChatRepository groupChatRepository;

    @PostMapping("/get-group-by-id")
    public GroupChat getGroup(@RequestParam(name = "groupId") Long groupId){
        return groupChatRepository.findById(groupId).get();
    }

    @PostMapping("/")
    public List<GroupChat> getAllGroupOfUser(@RequestParam(name = "username") String username){
        return groupService.getAllGroupOfUser(username);
    }

    @PostMapping("/create-group")
    public GroupChat createGroup(@RequestBody GroupChatRequestDTO groupChatRequestDTO){
        return groupService.createGroup(groupChatRequestDTO);
    }

    @PostMapping("/get-messages")
    public List<Message> loadMessageOfGroup(@RequestParam(name = "groupId") Long groupId){
        return groupService.loadMessageOfGroup(groupId);
    }
}
