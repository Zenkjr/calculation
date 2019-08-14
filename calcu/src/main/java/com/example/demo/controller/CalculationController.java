package com.example.demo.controller;

import com.example.demo.entity.EMI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalculationController {

    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> create(@RequestBody EMI emi) {
        double l = emi.getLoan();
        double r = emi.getRate();
        r = r / (12 * 100);
        double n = emi.getTenure();

        double result = l*r*Math.pow(1 + r, n) / (Math.pow(1 + r, n) - 1);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
