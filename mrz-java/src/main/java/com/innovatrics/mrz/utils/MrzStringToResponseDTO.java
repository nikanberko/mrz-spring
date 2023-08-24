package com.innovatrics.mrz.utils;

import com.innovatrics.mrz.MrzResponseDTO;

public class MrzStringToResponseDTO {

    public static MrzResponseDTO mrzStringToResponseDto(String mrz) {
        MrzResponseDTO mrzResponseDTO = new MrzResponseDTO();

        // Extract values using custom logic
        String code = extractValue(mrz, "code=(\\S+)");
        String issuingCountry = extractValue(mrz, "issuingCountry=(\\S+)");
        String documentNumber = extractValue(mrz, "documentNumber=(\\S+)");
        String surname = extractValue(mrz, "surname=(\\S+)");
        String givenNames = extractValue(mrz, "givenNames=(\\S+)");
        String dateOfBirth = extractValue(mrz, "dateOfBirth=\\{([^\\}]+)\\}");
        String sex = extractValue(mrz, "sex=(\\S+)");
        String expirationDate = extractValue(mrz, "expirationDate=\\{([^\\}]+)\\}");
        String nationality = extractValue(mrz, "nationality=([^\\}]+)\\}");
        String optional = extractValue(mrz, "optional=(\\S+)");

        // Set values in DTO
        mrzResponseDTO.setCode(code);
        mrzResponseDTO.setIssuingCountry(issuingCountry);
        mrzResponseDTO.setDocumentNumber(documentNumber);
        mrzResponseDTO.setSurname(surname);
        mrzResponseDTO.setGivenNames(givenNames);
        mrzResponseDTO.setDateOfBirth(dateOfBirth);
        mrzResponseDTO.setSex(sex);
        mrzResponseDTO.setExpirationDate(expirationDate);
        mrzResponseDTO.setNationality(nationality);
        mrzResponseDTO.setOptional(optional);
        mrzResponseDTO.setOptional2("");

        return mrzResponseDTO;
    }

    private static String extractValue(String input, String pattern) {
        java.util.regex.Pattern regex = java.util.regex.Pattern.compile(pattern);
        java.util.regex.Matcher matcher = regex.matcher(input);

        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
