package dreamdays.Helf.domain.user.entity;

import dreamdays.Helf.domain.user.entity.enums.Department;
import dreamdays.Helf.domain.user.entity.enums.Gender;
import dreamdays.Helf.domain.user.entity.enums.Mbti;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter @Setter
@Table(name = "User")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
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
}
