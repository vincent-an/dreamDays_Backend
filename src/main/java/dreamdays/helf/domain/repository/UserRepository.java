package dreamdays.helf.domain.repository;
import dreamdays.helf.domain.Entity.enums.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    // 회원 저장
    public void save(User user) {
        em.persist(user);
    }

    // 단일 회원 조회 (ID 기준)
    public User findOne(Long id) {
        return em.find(User.class, id);
    }

    // 전체 회원 조회 (JPQL 사용)
    public List<User> findAll() {
        return em.createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }

    // 학번과 이름으로 특정 사용자 조회 (JPQL 사용)
    public Optional<User> findByNameAndStudentNumber(String name, Long studentNumber) {
        return em.createQuery("SELECT u FROM User u WHERE u.name = :name AND u.studentNum = :studentNumber", User.class)
                .setParameter("name", name)
                .setParameter("studentNumber", studentNumber)
                .getResultList()
                .stream()
                .findFirst();
    }
}