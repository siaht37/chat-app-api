package hoangquochthai.chatapp.repository;

import hoangquochthai.chatapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
