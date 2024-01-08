package hoangquochthai.chatapp.repository;

import hoangquochthai.chatapp.entity.Friend;
import hoangquochthai.chatapp.entity.User;
import hoangquochthai.chatapp.entity.compositeKey.FriendShipId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FriendRepository extends JpaRepository<Friend, FriendShipId> {
    List<Friend> findAllByUser(User user);
    @Query("select f.friendOfUser from Friend f where f.user.username = :username")
    List<User> findAllFriendsByUser(@Param("username") String username);
}

