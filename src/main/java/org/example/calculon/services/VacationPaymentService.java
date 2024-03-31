package org.example.calculon.services;

import org.example.calculon.model.VacationPayment;
import org.example.calculon.util.VacationPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacationPaymentService {

    @Autowired
    VacationPay vacationPay;
    public double calculatePayment(VacationPayment vacationPayment) {
        return vacationPay.calculteVacationPay(vacationPayment);
    }

}