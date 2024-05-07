package com.example.middleware2.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/month")
public class MonthController {

    @GetMapping("")
    public MonthEntity getMonth(@RequestParam("monthNumber") Integer monthNumber) {
        MonthEntity selectedMonth = MonthInterceptor.months.stream()
                .filter(month -> month.getMonthNumber().equals(monthNumber))
                .findFirst()
                .orElseGet(() -> new MonthEntity(-1, "None", "None", "None"));

        return selectedMonth;
    }
}
