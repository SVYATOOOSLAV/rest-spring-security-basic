package by.svyat.spring.security.basic.controller;

import by.svyat.spring.security.basic.common.OrderResponse;
import org.springframework.context.annotation.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @GetMapping("/orders/{id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable int id) {
        return ResponseEntity.ok(new OrderResponse(String.format("Order #%d", id)));
    }
}
