package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Order;
import za.ac.cput.repository.OrderRepository;
import java.util.HashSet;
import java.util.Set;

@Service
public class OrderService  implements IOrderService{
    private final OrderRepository orderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order read(Integer integer) {
        return orderRepository.findById(integer).orElseThrow();
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Set<Order> getAll() {
        return new HashSet<>(orderRepository.findAll());
    }
}
