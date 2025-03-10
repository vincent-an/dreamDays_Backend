package dreamdays.Helf.domain.draw.dto;

import dreamdays.Helf.domain.user.entity.User;
import dreamdays.Helf.domain.user.entity.enums.Department;
import dreamdays.Helf.domain.user.entity.enums.Gender;
import dreamdays.Helf.domain.user.entity.enums.Mbti;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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


    /**
     *    Entity에서 내가 사용하고 싶은 정보들만 뽑아서 (프론트로) 전달할 때 builder를 사용하여
     *    User를 Response로 바꿔서 전달한다.
     */
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
