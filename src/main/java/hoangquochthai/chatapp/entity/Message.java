package hoangquochthai.chatapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMessage;
    private String content;
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "sender_usernameFK")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "groupIdPFK")
    private GroupChat groupChat;

    @ManyToOne
    @JoinColumn(name = "typeIdPFK")
    private Type type;

}
