package io.github.lucasrbsouza.betonme.controller;

import io.github.lucasrbsouza.betonme.service.interfaces.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService services;
}
