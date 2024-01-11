package hoangquochthai.chatapp.repository;

import hoangquochthai.chatapp.entity.GroupChat;
import hoangquochthai.chatapp.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    @Query("select m from Message m where m.groupChat.groupId = :groupId order by m.createdAt")
    List<Message> findAllByGroupChat(@Param("groupId") Long groupId);
}
