package org.example.calculon.controller;

import org.example.calculon.model.VacationPayment;
import org.example.calculon.services.VacationPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calculacte")
public class VacationPaymentController {

    @Autowired
    private VacationPaymentService vacationPaymentService;

    @GetMapping
    public ResponseEntity<Double> createBook(@RequestBody VacationPaymentRequest vacationPaymentRequest) {
        VacationPayment vacationPayment = new VacationPayment();
        vacationPayment.setAvgSalary(vacationPaymentRequest.getAvgSalary());
        vacationPayment.setVacationsDays(vacationPaymentRequest.getVacationsDays());
        if(vacationPaymentRequest.getStartVacationDay() != null) {
            vacationPayment.setStartVacationDay(vacationPaymentRequest.getStartVacationDay());
        }
        double paymentToWorker = vacationPaymentService.calculatePayment(vacationPayment);
        return ResponseEntity.status(HttpStatus.OK).body(paymentToWorker);
    }

}