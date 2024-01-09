package hoangquochthai.chatapp.dto.requestDTO;

import hoangquochthai.chatapp.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupChatRequestDTO {
    private String username;
    private List<String> users;
}
