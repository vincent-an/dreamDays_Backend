package dreamdays.helf.domain.controller;

import dreamdays.helf.domain.dto.DrawRequestDto;
import dreamdays.helf.domain.dto.DrawResponseDto;
import dreamdays.helf.domain.Entity.enums.User;
import dreamdays.helf.domain.service.DrawService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/draw")
@RequiredArgsConstructor
public class DrawController {

    private final DrawService drawService;

    // 뽑기 요청 API
    @PostMapping
    public ResponseEntity<DrawResponseDto> drawUser(@RequestBody DrawRequestDto drawRequestDto) {
        User drawnUser = drawService.drawRandomUser(drawRequestDto.getName(), drawRequestDto.getStudentNumber());

        // DTO로 변환하여 반환
        DrawResponseDto responseDto = new DrawResponseDto(
                drawnUser.getName(),
                drawnUser.getStudentNumber(),
                drawnUser.getGender(),
                drawnUser.getInstagramId(),
                drawnUser.getBio()
        );

        return ResponseEntity.ok(responseDto);
    }
}