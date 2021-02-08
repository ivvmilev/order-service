package com.example.demo.services;

import com.example.demo.Order;
import com.example.demo.OrderServiceApplication;
import com.example.demo.ProductOrder;
import com.example.demo.dtos.OrderDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class OrderService
{
    private final RabbitTemplate rabbitTemplate;

    public OrderService(RabbitTemplate rabbitTemplate)
    {
        this.rabbitTemplate = rabbitTemplate;
    }

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    public void placeOrder(ProductOrder productOrder)
    {
        rabbitTemplate.convertAndSend(OrderServiceApplication.EXCHANGE_NAME, OrderServiceApplication.ROUTING_KEY, createOrder(productOrder));
        log.info("Order is placed in queue");
    }

    private OrderDto createOrder(ProductOrder productOrder)
    {
        return new OrderDto(
                productOrder.getProductId()
                , productOrder.getProductName()
                , productOrder.getQuantity());
    }
}
