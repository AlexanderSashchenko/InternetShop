package mate.academy.internetshop.service;

import java.util.List;
import java.util.Optional;

import mate.academy.internetshop.model.Item;
import mate.academy.internetshop.model.Order;
import mate.academy.internetshop.model.User;

public interface OrderService {

    Optional<Order> get(Long id);

    Optional<Order> update(Order order);

    boolean delete(Long id);

    List<Order> getUserOrders(User user);

    Order completeOrder(List<Item> items, User user);
}
