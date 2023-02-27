package src.server.database.Repository;

import src.server.database.Entity.HerosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.transaction.annotation.Propagation.MANDATORY;

@Repository
@Transactional(propagation = MANDATORY)
public interface HerosRepository extends JpaRepository<HerosEntity, String> {
    //HerosEntity findByString(String id);
}