package com.example.middleware2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthEntity {

    private Integer monthNumber;
    private String englishName;
    private String italianName;
    private String germanName;
}
