package hoangquochthai.chatapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupChat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;
    private String groupName;
    private String groupAvatar;
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "creator_usernameFK")
    private User creator;

    @OneToMany(mappedBy = "groupChat")
    @JsonBackReference
    private Set<GroupUser> groupUsers;

    @OneToMany(mappedBy = "groupChat")
    @JsonBackReference
    private Set<Message> messages;
}
