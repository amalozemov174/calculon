package org.example.calculon.controller;

import lombok.Data;

import java.util.Date;

@Data
public class VacationPaymentRequest {
    private double avgSalary;
    private int vacationsDays;
    private Date startVacationDay;
}
