package ov4.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ov4.backend.models.ComputeResult;

@Service
public class ComputeService {
    
    public double simpleCalculate(double firstTerm, String operator, double secondTerm) {
        switch (operator) {
            case "+":
                return firstTerm + secondTerm;
            case "*":
                return firstTerm * secondTerm;
            case "-":
                return firstTerm - secondTerm;
            case "/":
                return firstTerm / secondTerm;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    public ComputeResult calculate(List<String> to_compute) {
    if (to_compute.size() < 3) {
        throw new IllegalArgumentException("Equation must have at least 3 terms");
    }
    
    double result = Double.parseDouble(to_compute.get(0));
    
    for (int i = 1; i < to_compute.size(); i += 2) {
        String operator = to_compute.get(i);
        double secondTerm = Double.parseDouble(to_compute.get(i + 1));
        result = simpleCalculate(result, operator, secondTerm);
    }
    
    return new ComputeResult(result, String.join("", to_compute));
}
}
