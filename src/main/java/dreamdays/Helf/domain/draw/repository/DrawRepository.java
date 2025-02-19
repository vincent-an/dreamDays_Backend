package dreamdays.Helf.domain.draw.repository;

import dreamdays.Helf.domain.user.entity.User;
import dreamdays.Helf.domain.user.entity.enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DrawRepository extends JpaRepository<User, Long> {

    // 성별로 유저 조회
    List<User> findByGender(Gender selectGender);

}
