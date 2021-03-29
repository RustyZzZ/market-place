package diachuk.project.marketplace.repos;

import diachuk.project.marketplace.entity.security.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
		Optional<User> findByUsername(String username);
}
