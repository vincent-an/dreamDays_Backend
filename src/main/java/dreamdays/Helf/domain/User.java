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

    private Long studentName;

    private String instagramId;

    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Department department;

    @Enumerated(EnumType.STRING)
    private Mbti mbti;

    @Enumerated(EnumType.STRING)
    private SelectGender selectGender;

    private String bio;

    //짝궁 관계 OneToOne관계 사용
    /**
     * User테이블 안에 friend_id 컬럼 생성, unique = true하여 1:1 관계 형성
     */
    @OneToOne
    @JoinColumn(name = "friend_id", unique = true)
    private User friend;
}
