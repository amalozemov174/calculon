package org.example.calculon.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class VacationPayment {
    private double avgSalary;
    private int vacationsDays;
    private Date startVacationDay;
}
