package dreamdays.helf.domain.draw.service;

import dreamdays.helf.domain.draw.dto.DrawResponse;
import dreamdays.helf.domain.user.entity.enums.Gender;
import dreamdays.helf.domain.user.entity.User;
import dreamdays.helf.domain.draw.repository.DrawRepository;
import dreamdays.helf.domain.user.repository.UserRepository;
import dreamdays.helf.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DrawService {

    private final DrawRepository drawRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final Random random = new Random();

    // 특정 성별 유저 중 랜덤 뽑기 (뽑을 수 있는 사람이 없어도 명단에서 다시 뽑기)
    public List<User>findByGender(Gender selectGender) {
        return drawRepository.findByGender(selectGender);
    }

    //뽑기 로직
    @Transactional
    public User drawRandomUser(String name, int studentNumber) {
        //뽑는 유저 조회
       User user = UserService.findByNameAndStudentNumber(name, studentNumber);
        //UserService.findByNameAndStudentNumber(name, studentNumber);

        //뽑고싶은 성별에 맞는 유저 리스트 조회
        List<User> availableUsers = findByGender(user.getSelectGender());

        // 1. picked가 false인 사람들 중에서 뽑기
        List<User> notPickedUsers = availableUsers.stream()
                .filter(u -> !u.isPicked())
                .collect(Collectors.toList());

        User drawnUser = null;

        if (!notPickedUsers.isEmpty()) {
            // picked가 false인 사람들에서 랜덤으로 선택
            drawnUser = selectRandomUser(notPickedUsers);
        } else {
            // picked가 true인 사람들 중에서 랜덤으로 뽑기
            List<User> pickedUsers = availableUsers.stream()
                    .filter(u -> u.isPicked())
                    .collect(Collectors.toList());

            if (!pickedUsers.isEmpty()) {
                drawnUser = selectRandomUser(pickedUsers);
            } else {
                throw new IllegalStateException("조건에 맞는 사용자가 없습니다.");
            }
        }

        // 3. 뽑기 후 상태 변경
        user.setDraw(true);
        drawnUser.setPicked(true);

     return drawnUser; //return DrawResponse.from(drawnUser)
    }

    private User selectRandomUser(List<User> users) {
        Random random = new Random();
        return users.get(random.nextInt(users.size()));
    }
}



