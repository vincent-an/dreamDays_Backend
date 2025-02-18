package dreamdays.Helf.domain.user.dto;
import dreamdays.Helf.domain.user.entity.User;
import lombok.Getter;

@Getter
public class CheckInfoResponse {

    private final String name;  // 학생 이름
    private final int studentNumber;  // 학과

    public CheckInfoResponse(String name, int studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
    }

    public static CheckInfoResponse from(User user) {
        return new CheckInfoResponse(user.getName(), user.getStudentNumber());
    }
}

