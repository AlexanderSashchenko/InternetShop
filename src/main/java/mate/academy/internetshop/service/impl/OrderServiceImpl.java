package mate.academy.internetshop.service.impl;

import java.util.List;
import java.util.Optional;

import mate.academy.internetshop.dao.OrderDao;
import mate.academy.internetshop.lib.Inject;
import mate.academy.internetshop.model.Item;
import mate.academy.internetshop.model.Order;
import mate.academy.internetshop.model.User;
import mate.academy.internetshop.service.OrderService;

public class OrderServiceImpl implements OrderService {

    @Inject
    private static OrderDao orderDao;

    @Override
    public Optional<Order> get(Long id) {
        return orderDao.get(id);
    }

    @Override
    public Optional<Order> update(Order order) {
        return orderDao.update(order);
    }

    @Override
    public boolean delete(Long id) {
        return orderDao.delete(id);
    }

    @Override
    public List<Order> getUserOrders(User user) {
        return orderDao.getUserOrders(user);
    }

    @Override
    public Order completeOrder(List<Item> items, User user) {
        Order newOrder = new Order();
        newOrder.setUserId(user.getId());
        newOrder.setItemsInOrder(items);
        orderDao.create(newOrder);
        return newOrder;
    }
}
