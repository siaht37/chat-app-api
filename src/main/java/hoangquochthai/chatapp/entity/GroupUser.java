package hoangquochthai.chatapp.entity;

import hoangquochthai.chatapp.entity.compositeKey.GroupUserId;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(GroupUserId.class)
public class GroupUser {
    @Id
    @ManyToOne
    @JoinColumn(name = "groupIdPFK")
    private GroupChat groupChat;

    @Id
    @ManyToOne
    @JoinColumn(name = "usernamePFK")
    private User user;

}
