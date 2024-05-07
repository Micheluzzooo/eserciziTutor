package com.example.middleware2.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/month")
@AllArgsConstructor
public class MonthController {

    @GetMapping("/{monthNumber}")
    public MonthEntity getMonth(@PathVariable("monthNumber") Integer monthNumber) {
        return MonthInterceptor.months.stream().filter(month -> month.getMonthNumber().equals(monthNumber)).findFirst().orElseGet(() -> new MonthEntity(-1, "None", "None", "None"));
    }

}
