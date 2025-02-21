package dreamdays.Helf.domain.user.dto;
import dreamdays.Helf.domain.user.entity.User;
import lombok.Getter;

@Getter
public class CheckInfoResponse {

    private final String name;  // 학생 이름
    private final int studentNumber;  // 학과
    private final boolean isDraw;

    public CheckInfoResponse(String name, int studentNumber, boolean isDraw) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.isDraw = isDraw;
    }

    public static CheckInfoResponse from(User user) {
        return new CheckInfoResponse(user.getName(), user.getStudentNumber(), user.isDraw());
    }
}