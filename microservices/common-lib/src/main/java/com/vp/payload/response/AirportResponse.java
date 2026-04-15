package com.vp.payload.response;

import com.vp.Embeddable.Address;
import com.vp.Embeddable.GeoCode;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AirportResponse {

    private Long id;
    private String iataCode;
    private String name;
    private String detailedName;
    private String timeZone;
    private Address address;
    private CityResponse city;
    private GeoCode geoCode;

}
