package com.vp.Embeddable;

import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.*;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {

    private String street;

    private String postalcode;
}
