package dreamdays.helf.domain.draw.controller;

import dreamdays.helf.domain.draw.dto.DrawRequest;
import dreamdays.helf.domain.draw.dto.DrawResponse;
import dreamdays.helf.domain.user.entity.User;
import dreamdays.helf.domain.draw.service.DrawService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DrawController {
    private final DrawService drawService;

    // 뽑기 요청 API
    @PostMapping("/draw")
    public ResponseEntity<DrawResponse> Postrandomdraw(@RequestBody DrawRequest drawRequest) {
        DrawResponse response = DrawResponse.from(drawService.drawRandomUser(drawRequest.getName(), drawRequest.getStudentNumber()));

        return ResponseEntity.ok(response);
    }
}