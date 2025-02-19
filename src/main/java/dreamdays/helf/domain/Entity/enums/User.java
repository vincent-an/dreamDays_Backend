package dreamdays.helf.domain.Entity.enums;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@Table(name = "User")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    @Column(nullable = false)
    private String name; //학생 이름

    @Column(nullable = false, unique = true)
    private int studentNumber; //학번

    @Column(nullable = false)
    private String instagramId; //인스타id

    @Column(nullable = false)
    private int age; //나이

    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private Gender gender; //성별

    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private Department department; //학과

    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private Mbti mbti; //mbti

    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private Gender selectGender; //뽑고싶은 성별

    private String bio; // 한줄소개

    private boolean picked; // 뽑힌 여부 (뽑힌 사람)

    private boolean isDraw; // 뽑기 여부 (뽑는 사람)



//    //짝궁 관계 OneToOne관계 사용
//    /**
//     * User테이블 안에 friend_id 컬럼 생성, unique = true하여 1:1 관계 형성
//     */
//    @OneToOne
//    @JoinColumn(name = "friend_id", unique = true)
//    private User friend;
}
