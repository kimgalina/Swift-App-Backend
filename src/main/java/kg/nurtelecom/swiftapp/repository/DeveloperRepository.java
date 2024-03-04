package kg.nurtelecom.swiftapp.repository;

import kg.nurtelecom.swiftapp.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {
}
