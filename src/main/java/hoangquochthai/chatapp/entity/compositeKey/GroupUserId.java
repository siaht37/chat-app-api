package hoangquochthai.chatapp.entity.compositeKey;
import hoangquochthai.chatapp.entity.GroupChat;
import hoangquochthai.chatapp.entity.User;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupUserId implements Serializable {
    private GroupChat groupChat;
    private User user;

}
