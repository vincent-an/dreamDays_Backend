package dreamdays.Helf.domain.user.controller;

import dreamdays.Helf.domain.user.dto.CheckInfoResponse;
import dreamdays.Helf.domain.user.dto.InfoRequest;
import dreamdays.Helf.domain.user.entity.User;
import dreamdays.Helf.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PostMapping("/create-info")
    public ResponseEntity<String> postInfoUser(@RequestBody InfoRequest infoRequest) {
        //UserEntity가 기본적으로 Protect여서 toEntity()를 만들지 못한다...
        //@Bliuder 사용해서 만들었는데 해결 됐을까요..?
        userService.saveUser(infoRequest);
        return ResponseEntity.ok("정보 입력 완료");
    }

    @GetMapping("/check-info")
    public ResponseEntity<CheckInfoResponse> getCheckUser(
            @RequestParam String name,
            @RequestParam int studentNumber
    ) {
        CheckInfoResponse response = userService.findByNameAndStudentNumber(name, studentNumber);
        return ResponseEntity.ok(response);
    }
}
