package dreamdays.Helf.domain.user.repository;

import dreamdays.Helf.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // 이미 저장된 회원인지 조회 (학번, 이름으로 조회)
    Optional<User> findByNameAndStudentNumber(String name, int studentNumber);

    // 이름과 학번을 기준으로 존재하는지 확인
    boolean existsByNameAndStudentNumber(String name, int studentNumber);
}

