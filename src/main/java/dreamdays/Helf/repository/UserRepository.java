package dreamdays.Helf.repository;

import dreamdays.Helf.domain.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    //회원 저장
    public void save(User user) {
        em.persist(user);
    }

    //단일 회원 조회
    public User findOne(Long id) {
        return em.find(User.class, id);
    }

    //전체 회원 조회
    public List<User> findALl() {
        return em.createQuery("select u from User u", User.class)
                .getResultList();
    }

    //이미 저장된 회원인지 조회 학번, 이름으로 조회
    public Optional<User> findByNameAndStudentNumber(String name, int studentNumber) {
        return em.createQuery("select u from User u where u.name = :name and u.studentNumber = :studentNumber", User.class)
                .setParameter("name", name)
                .setParameter("studentNumber", studentNumber)
                .getResultList()
                .stream().findFirst();
    }
}
