package com.innovatrics.mrz;

import com.innovatrics.mrz.utils.MrzStringToResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ParsingController {

    @PostMapping("/parse")
    @ResponseStatus(HttpStatus.OK)
    public MrzResponseDTO parseMRZ(@RequestBody MrzDTO mrzDTO){
        String parsedMrz=MrzParser.parse(mrzDTO.getMrz()).toString();
        return MrzStringToResponseDTO.mrzStringToResponseDto(parsedMrz);
    }
}
