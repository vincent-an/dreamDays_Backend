package dreamdays.Helf.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    private String name; //학생 이름

    private int studentNumber; //학번

    private String instagramId; //인스타id

    private int age; //나이

    @Enumerated(EnumType.STRING)
    private Gender gender; //성별

    @Enumerated(EnumType.STRING)
    private Department department; //학과

    @Enumerated(EnumType.STRING)
    private Mbti mbti; //mbti

    @Enumerated(EnumType.STRING)
    private SelectGender selectGender; //뽑고싶은 성별

    private String bio; // 한줄소개

    //짝궁 관계 OneToOne관계 사용
    /**
     * User테이블 안에 friend_id 컬럼 생성, unique = true하여 1:1 관계 형성
     */
    @OneToOne
    @JoinColumn(name = "friend_id", unique = true)
    private User friend;
}
