package com.example.demo.services;

import com.example.demo.Order;
import com.example.demo.OrderServiceApplication;
import com.example.demo.dtos.OrderDto;
import com.example.demo.repositories.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ListenerClass
{
    private static final Logger log = LoggerFactory.getLogger(ListenerClass.class);

    private final OrderRepository orderRepository;

    public ListenerClass(OrderRepository orderRepository)
    {
        this.orderRepository = orderRepository;
    }

    @RabbitListener(queues = OrderServiceApplication.DEFAULT_PARSING_QUEUE)
    public void consumeMessage(OrderDto orderDto)
    {
        Order order = new Order();
        order.setQuantity(orderDto.getQuantity());
        order.setProduct(orderDto.getProduct());
        order.setLastModifiedDate(orderDto.getLastModifiedDate());
        order.setCreatedDate(orderDto.getCreatedDate());
        order.setProductId(orderDto.getProductId());
        order.setCreatedDate(LocalDate.now());
        orderRepository.save(order);
        log.info("Order is saved " + order.toString());
    }
}
