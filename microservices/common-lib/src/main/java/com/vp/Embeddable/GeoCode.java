package com.vp.Embeddable;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GeoCode {
    private double latitude;
    private double longitude;
}
