package hoangquochthai.chatapp.entity.compositeKey;

import hoangquochthai.chatapp.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FriendShipId implements Serializable {
    private User user;
    private User friendOfUser;

}
