package dreamdays.Helf.domain.draw.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DrawRequest {
    // 뽑기를 요청할 때 필요한 정보 (이름, 학번)
    private String name;
    private int studentNumber;
}
