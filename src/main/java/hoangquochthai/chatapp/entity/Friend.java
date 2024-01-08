package hoangquochthai.chatapp.entity;

import hoangquochthai.chatapp.entity.compositeKey.FriendShipId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(FriendShipId.class)
public class Friend {
    @Id
    @ManyToOne
    @JoinColumn(name = "usernamePFK")
    private User user;
    @Id
    @ManyToOne
    @JoinColumn(name = "friendUsernamePFK")
    private User friendOfUser;
}
