package mate.academy.internetshop.dao.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import mate.academy.internetshop.dao.BucketDao;
import mate.academy.internetshop.lib.Dao;
import mate.academy.internetshop.model.Bucket;
import mate.academy.internetshop.model.Item;
import mate.academy.internetshop.storage.IdGenerator;
import mate.academy.internetshop.storage.Storage;

@Dao
public class BucketDaoImpl implements BucketDao {

    @Override
    public Bucket create(Bucket bucket) {
        Bucket newBucket = new Bucket();
        newBucket.setId(IdGenerator.getBucketId());
        return newBucket;
    }

    @Override
    public Optional<Bucket> get(Long id) {
        return Optional.ofNullable(Storage.buckets.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Can't find bucket with id: "
                        + id)));
    }

    @Override
    public Optional<Bucket> update(Bucket bucket) {
        return Optional.ofNullable(Storage.buckets.stream()
                .filter(b -> b.getId().equals(bucket.getId()))
                .map(b -> bucket)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Can't find bucket with id: "
                        + bucket.getId())));
    }

    @Override
    public boolean delete(Long id) {
        Optional<Bucket> toDelete = get(id);
        return toDelete.map(Storage.buckets::remove).orElse(false);
    }

    @Override
    public Bucket addItem(Bucket bucket, Item item) {
        List<Item> updatedItems = bucket.getItemsInBucket();
        updatedItems.add(item);
        bucket.setItemsInBucket(updatedItems);
        return bucket;
    }

    @Override
    public Bucket deleteItem(Bucket bucket, Item item) {
        List<Item> updatedItems = bucket.getItemsInBucket();
        updatedItems.remove(item);
        bucket.setItemsInBucket(updatedItems);
        return bucket;
    }

    @Override
    public Bucket clear(Bucket bucket) {
        List<Item> updatedItems = bucket.getItemsInBucket();
        updatedItems.clear();
        bucket.setItemsInBucket(updatedItems);
        return bucket;
    }

    @Override
    public List<Item> getAllItems(Bucket bucket) {
        return bucket.getItemsInBucket();
    }
}
