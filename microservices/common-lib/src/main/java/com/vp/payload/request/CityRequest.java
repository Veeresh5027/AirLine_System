package com.vp.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CityRequest {

    @NotBlank(message = "City Name is required")
    @Size(max = 100, message = "City Name should be less than 100 characters")
    private String name;

    @NotBlank(message = "City Code is required")
    @Size(max = 10, message = "City Code should be less than 10 characters")
    private String cityCode;

    @NotBlank(message = "Country Code is required")
    @Size(max = 5, message = "Country Code should be less than 5 characters")
    private String countryCode;

    @NotBlank(message = "Country Name is required")
    @Size(max = 100, message = "Country Name should be less than 100 characters")
    private String countryName;

    @Size(max = 10, message = "Region Code should be less than 10 characters")
    private String regionCode;

    @Size(max = 10, message = "Time Zone Offset should be less than 10 characters")
    private String timeZoneOffset;
}
