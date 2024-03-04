package kg.nurtelecom.swiftapp.repository;

import kg.nurtelecom.swiftapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
