package com.vp.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String cityCode;

    @Column(nullable = false)
    private String countryCode;

    @Column(nullable = false)
    private String countryName;

    @Column(name = "region_code", length = 10)
    private String regionCode;

    @Column(name = "time_zone_id", length = 50)
    private String timeZoneId;

}
