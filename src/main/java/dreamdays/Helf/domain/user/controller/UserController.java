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

    @PostMapping("/users/create-info")
    public ResponseEntity<String> postInfoUser(@RequestBody InfoRequest infoRequest) {
        userService.saveUser(infoRequest);
        return ResponseEntity.ok("정보 입력 완료");
    }

    @GetMapping("/users/check-info")
    public ResponseEntity<CheckInfoResponse> getCheckUser(
            @RequestParam String name,
            @RequestParam int studentNumber
    ) {
        CheckInfoResponse response = userService.findByNameAndStudentNumber(name, studentNumber);
        return ResponseEntity.ok(response);
    }
}
