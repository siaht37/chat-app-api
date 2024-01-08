package hoangquochthai.chatapp.repository;

import hoangquochthai.chatapp.entity.GroupUser;
import hoangquochthai.chatapp.entity.compositeKey.GroupUserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupUserRepository extends JpaRepository<GroupUser, GroupUserId> {
}
