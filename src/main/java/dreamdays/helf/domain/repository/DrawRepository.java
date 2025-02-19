package dreamdays.helf.domain.repository;

import dreamdays.helf.domain.Entity.enums.Gender;
import dreamdays.helf.domain.Entity.enums.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrawRepository extends JpaRepository<User, Long> {

    // 성별로 유저 조회
    List<User> findByGender(Gender selectGender);

}