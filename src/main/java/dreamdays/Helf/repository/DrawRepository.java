package dreamdays.Helf.repository;

import dreamdays.Helf.domain.SelectGender;
import dreamdays.Helf.domain.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

@Repository
@RequiredArgsConstructor
public class DrawRepository {

    private final EntityManager em;

    //전체 유저 조회
    public List<User> findALl() {
        return em.createQuery("select u from User u", User.class)
                .getResultList();
    }

    // 랜덤 뽑기
    public User drawRandomUser(SelectGender selectGender) {
        List<User> users = em.createQuery(
                        "SELECT u FROM User u WHERE u.selectGender = :selectGender", User.class)
                .setParameter("selectGender", selectGender)
                .getResultList();

        if (users.isEmpty()) {
            throw new IllegalStateException("조건에 맞는 학생이 없습니다.");
        }

        Random random = new Random();
        return users.get(random.nextInt(users.size()));
    }

    // 짝궁 관계를 추가해주는 로직 여기서 구현해야되나?
}
