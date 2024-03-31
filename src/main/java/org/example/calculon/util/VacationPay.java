package org.example.calculon.util;

import org.example.calculon.model.VacationPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.ZoneId;
import java.util.Date;

@Component
public class VacationPay {

    @Autowired
    Holiday holiday;

    private static final int MONTH_AMOUNT = 12;
    private static final int MIN_DAY_AMOUNT = 1;
    private static final int MAX_DAY_AMOUNT = 28;
    private static final double AVG_WORK_DAYS = 29.3;
    private static final double TAX_RATE = 0.13;

    public double calculteVacationPay(VacationPayment vacationPayment) {
        if (vacationPayment.getVacationsDays() < MIN_DAY_AMOUNT || vacationPayment.getVacationsDays() > MAX_DAY_AMOUNT) {
            throw new RuntimeException("Incorrect paramter vacationDays " + vacationPayment.getVacationsDays());
        }
        int tmpVacationDays = vacationPayment.getVacationsDays();
        if (vacationPayment.getStartVacationDay() != null) {
            LocalDate localDate = vacationPayment.getStartVacationDay().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            for (int i = 1; i <  vacationPayment.getVacationsDays(); i++) {
                if (holiday.isHoliday(MonthDay.of(localDate.getMonthValue(), localDate.getDayOfMonth()))){
                    tmpVacationDays = tmpVacationDays - 1;
                    localDate = localDate.plusDays(1);
                }
                localDate = localDate.plusDays(1);
            }
        }
        double totalIncome = vacationPayment.getAvgSalary() * MONTH_AMOUNT;
        double averageDayIncome = totalIncome / (MONTH_AMOUNT * AVG_WORK_DAYS);
        double vacationPay = averageDayIncome * tmpVacationDays;
        double personTax = vacationPay * TAX_RATE;
        double res = vacationPay - personTax;
        return Math.round(res);
    }

}
