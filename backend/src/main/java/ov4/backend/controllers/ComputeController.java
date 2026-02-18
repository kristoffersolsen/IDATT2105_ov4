package ov4.backend.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import ov4.backend.models.Equation;
import ov4.backend.service.ComputeService;
import ov4.backend.models.ComputeResult;


@RestController
@RequestMapping("/compute")
public class ComputeController {
    
    private final ComputeService computeService;
    
    public ComputeController(ComputeService computeService) {
        this.computeService = computeService;
    }

    @PostMapping
    public ResponseEntity<ComputeResult> calculate(@RequestBody Equation equation) {
        List<String> tokens = Arrays.asList(equation.equation());
        return ResponseEntity.ok(computeService.calculate(tokens));
    }
}
