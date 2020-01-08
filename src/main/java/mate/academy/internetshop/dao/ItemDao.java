package mate.academy.internetshop.dao;

import java.util.List;
import java.util.Optional;

import mate.academy.internetshop.model.Item;

public interface ItemDao {

    Item create(Item item);

    Optional<Item> get(Long id);

    Optional<Item> update(Item item);

    List<Item> getAllItems();

    boolean delete(Long id);

    boolean deleteByItem(Item item);
}
