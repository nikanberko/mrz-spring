package com.innovatrics.mrz;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ParsingController {

    @PostMapping("/parse")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    String parseMRZ(@RequestBody MrzDTO mrzDTO){
        return MrzParser.parse(mrzDTO.getMrz()).toString();
    }
}
