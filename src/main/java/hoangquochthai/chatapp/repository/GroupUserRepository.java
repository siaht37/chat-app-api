package hoangquochthai.chatapp.repository;

import hoangquochthai.chatapp.entity.GroupChat;
import hoangquochthai.chatapp.entity.GroupUser;
import hoangquochthai.chatapp.entity.compositeKey.GroupUserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupUserRepository extends JpaRepository<GroupUser, GroupUserId> {
    @Query("select g.groupChat from GroupUser g where g.user.username = :username")
    List<GroupChat> findAllByUser(@Param("username") String username);

    @Query("select g from GroupUser g where g.groupChat.groupId = :groupId")
    List<GroupUser> findAllByGroupChat(@Param("groupId") Long groupId);
}
