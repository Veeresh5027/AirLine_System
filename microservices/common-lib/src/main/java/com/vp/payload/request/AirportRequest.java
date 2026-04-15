package com.vp.payload.request;

import com.vp.Embeddable.Address;
import com.vp.Embeddable.GeoCode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZoneId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AirportRequest {

    @NotBlank(message = "Iata code is required")
    @Size(max = 3, min = 3, message = "Iata code must be exactly 3 characters long")
    private String iataCode;

    @NotBlank(message = "Name is required")
    private String name;

    private ZoneId timeZone;

    @Valid
    private Address address;

    @NotNull(message = "City ID is required")
    private Long cityId;

    @Valid
    private GeoCode geoCode;
}
