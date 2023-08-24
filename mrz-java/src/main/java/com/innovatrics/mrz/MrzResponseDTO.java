package com.innovatrics.mrz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class MrzResponseDTO {

    private String code;
    private String issuingCountry;
    private String documentNumber;
    private String surname;
    private String givenNames;
    private String dateOfBirth;
    private String sex;
    private String expirationDate;
    private String nationality;
    private String optional;
    private String optional2;

}
