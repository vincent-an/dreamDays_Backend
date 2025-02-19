package dreamdays.helf.domain.draw.dto;

import dreamdays.helf.domain.user.entity.User;
import dreamdays.helf.domain.user.entity.enums.Department;
import dreamdays.helf.domain.user.entity.enums.Gender;
import dreamdays.helf.domain.user.entity.enums.Mbti;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DrawResponse {
    //뽑힌 사용자 정보 중에 필요한 정보
    private String name;
    private int age;
    private String instagramId;
    private Department department;
    private Gender gender;
    private Mbti mbti;
    private String bio;

    public static DrawResponse from(User user) {
        return DrawResponse.builder()
                .name(user.getName())
                .age(user.getAge())
                .instagramId(user.getInstagramId())
                .department(user.getDepartment())
                .gender(user.getGender())
                .mbti(user.getMbti())
                .bio(user.getBio())
                .build();
    }
}