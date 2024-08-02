package anuar.shop_spring.service;

import anuar.shop_spring.entity.Order;
import anuar.shop_spring.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<Order> getAllOrders () {
        return orderRepository.findAll();
    }
}
