package com.example.middleware2.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MonthEntity {

    private Integer monthNumber;
    private String englishName;
    private String italianName;
    private String germanName;

    public MonthEntity(Integer monthNumber, String englishName, String italianName, String germanName) {
        this.monthNumber = monthNumber;
        this.englishName = englishName;
        this.italianName = italianName;
        this.germanName = germanName;
    }
}
