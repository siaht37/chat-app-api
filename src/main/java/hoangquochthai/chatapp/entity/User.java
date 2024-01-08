package hoangquochthai.chatapp.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;


@Entity
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String username;
    @JsonIgnore
    private String password;
    private String fullName;
    private String userAvatar;
    private Date createdAt;

    @OneToMany(mappedBy = "creator")
    @JsonBackReference
    private Set<GroupChat> groupChats;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private Set<GroupUser> groupUsers;

    @OneToMany(mappedBy = "sender")
    @JsonBackReference
    private Set<Message> messages;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private Set<Friend> friendsOfUser;

    @OneToMany(mappedBy = "friendOfUser")
    @JsonBackReference
    private Set<Friend> dontUse;

}