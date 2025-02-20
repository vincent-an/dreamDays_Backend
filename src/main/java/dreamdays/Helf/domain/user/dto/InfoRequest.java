package dreamdays.Helf.domain.user.dto;


import dreamdays.Helf.domain.user.entity.User;
import dreamdays.Helf.domain.user.entity.enums.Department;
import dreamdays.Helf.domain.user.entity.enums.Gender;
import dreamdays.Helf.domain.user.entity.enums.Mbti;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class InfoRequest {
    private String name;
    private int studentNumber;
    private String instagramId;
    private int age;
    private Gender gender;
    private Department department;
    private Mbti mbti;
    private Gender selectGender;
    private String bio;

    public User toEntity() {
        return User.builder()
                .name(this.name)
                .studentNumber(this.studentNumber)
                .instagramId(this.instagramId)
                .age(this.age)
                .gender(this.gender)
                .department(this.department)
                .mbti(this.mbti)
                .selectGender(this.selectGender)
                .bio(this.bio)
                .picked(false)  // 초기값 false
                .isDraw(false)   // 초기값 true
                .build();
    }
}