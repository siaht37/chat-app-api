package hoangquochthai.chatapp.repository;

import hoangquochthai.chatapp.entity.GroupChat;
import hoangquochthai.chatapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupChatRepository extends JpaRepository<GroupChat, Long> {
    List<GroupChat> findAllByCreator(User user);
}
