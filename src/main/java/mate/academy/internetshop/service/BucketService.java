package mate.academy.internetshop.service;

import java.util.List;

import mate.academy.internetshop.model.Bucket;
import mate.academy.internetshop.model.Item;

public interface BucketService extends ServiceGeneric<Bucket, Long> {

    Bucket addItem(Bucket bucket, Item item);

    Bucket deleteItem(Bucket bucket, Item item);

    Bucket clear(Bucket bucket);

    List<Item> getAllItems(Bucket bucket);
}
