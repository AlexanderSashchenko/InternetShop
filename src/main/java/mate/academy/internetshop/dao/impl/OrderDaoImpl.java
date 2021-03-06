package mate.academy.internetshop.dao.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import mate.academy.internetshop.dao.OrderDao;
import mate.academy.internetshop.lib.Dao;
import mate.academy.internetshop.model.Order;
import mate.academy.internetshop.model.User;
import mate.academy.internetshop.storage.IdGenerator;
import mate.academy.internetshop.storage.Storage;

@Dao
public class OrderDaoImpl implements OrderDao {
    @Override
    public Order create(Order order) {
        order.setId(IdGenerator.getOrderId());
        Storage.orders.add(order);
        return order;
    }

    @Override
    public Optional<Order> get(Long id) {
        return Optional.ofNullable(Storage.orders
                .stream()
                .filter(order -> order.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Can't find order with id: "
                        + id)));
    }

    @Override
    public Optional<Order> update(Order order) {
        return Optional.ofNullable(Storage.orders.stream()
                .filter(o -> o.getId().equals(order.getId()))
                .map(i -> order)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Can't find order with id: "
                        + order.getId())));
    }

    @Override
    public boolean delete(Long id) {
        Optional<Order> toDelete = get(id);
        return toDelete.map(Storage.orders::remove).orElse(false);
    }

    @Override
    public List<Order> getUserOrders(User user) {
        return Storage.orders.stream()
                .filter(o -> o.getUserId().equals(user.getId()))
                .collect(Collectors.toList());
    }
}
