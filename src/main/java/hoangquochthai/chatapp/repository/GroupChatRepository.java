package hoangquochthai.chatapp.repository;

import hoangquochthai.chatapp.entity.GroupChat;
import hoangquochthai.chatapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupChatRepository extends JpaRepository<GroupChat, Long> {

}
