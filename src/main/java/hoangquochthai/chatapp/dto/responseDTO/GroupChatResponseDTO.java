package hoangquochthai.chatapp.dto.responseDTO;

import hoangquochthai.chatapp.entity.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupChatResponseDTO {
    private Long groupId;
    private String groupName;
    private String groupAvatar;
    private List<Message> messages;
}
