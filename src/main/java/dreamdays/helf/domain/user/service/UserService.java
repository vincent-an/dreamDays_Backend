package dreamdays.helf.domain.user.service;
import dreamdays.helf.domain.user.entity.User;
import dreamdays.helf.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public static User findByNameAndStudentNumber(String name, int studentNumber) {
        return null;
    }

    // 사용자 저장
    public void saveUser(User user) {
        userRepository.save(user);
    }

    // 모든 사용자 조회
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 특정 학번과 이름으로 사용자 조회
    public Optional<User> getUserByStudentNumAndName(String name, Long studentNumber) {
        return userRepository.findByNameAndStudentNumber(name, studentNumber);
    }
}
