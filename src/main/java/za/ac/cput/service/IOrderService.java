package za.ac.cput.service;

import za.ac.cput.domain.Order;

import java.util.Set;

public interface IOrderService extends IService<Order, Integer> {
    Set<Order>getAll();
}