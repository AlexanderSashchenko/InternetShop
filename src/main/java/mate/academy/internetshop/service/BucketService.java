package mate.academy.internetshop.service;

import java.util.List;
import java.util.Optional;

import mate.academy.internetshop.model.Bucket;
import mate.academy.internetshop.model.Item;

public interface BucketService {

    Bucket create(Bucket bucket);

    Optional<Bucket> get(Long id);

    Optional<Bucket> update(Bucket bucket);

    boolean delete(Long id);

    Bucket addItem(Bucket bucket, Item item);

    Bucket deleteItem(Bucket bucket, Item item);

    Bucket clear(Bucket bucket);

    List<Item> getAllItems(Bucket bucket);
}
