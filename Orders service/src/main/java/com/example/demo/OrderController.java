package com.example.demo;

import com.example.demo.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController
{

    private final OrderService orderService;

    public OrderController(OrderService orderService)
    {
        this.orderService = orderService;
    }

    @PostMapping(value = "/order", consumes = "application/json", produces = "application/json" )
    public ResponseEntity<?> createOrder(
            @RequestBody ProductOrder productOrder
    )
    {
        orderService.placeOrder(productOrder);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/")
    public ResponseEntity<?> createOrder(
    )
    {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
