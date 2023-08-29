package com.innovatrics.mrz;

import com.innovatrics.mrz.security.TokenProvider;
import com.innovatrics.mrz.utils.MrzStringToResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ParsingController {

    private final TokenProvider tokenProvider;

    public ParsingController(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/parse")
    public ResponseEntity<MrzResponseDTO> parseMRZ(@RequestBody MrzDTO mrzDTO, HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if (token == null || !token.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        token = token.replace("Bearer ", "");

        String username;

        try {
            username = tokenProvider.getUsernameFromToken(token);
        } catch (Exception e) {
            System.out.println("HERE IS THE ERROR");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        String parsedMrz = MrzParser.parse(mrzDTO.getMrz()).toString();
        return ResponseEntity.status(HttpStatus.OK).body(MrzStringToResponseDTO.mrzStringToResponseDto(parsedMrz));
    }
}
