package dreamdays.helf.domain.dto;

import dreamdays.helf.domain.Entity.enums.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DrawResponseDto {
    private String name;
    private int studentNumber;
    private Gender gender;
    private String instagramId;
    private String bio;

    public DrawResponseDto(String name, int studentNumber, Gender gender, String instagramId, String bio) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.gender = gender;
        this.instagramId = instagramId;
        this.bio = bio;
    }
}