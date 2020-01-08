package mate.academy.internetshop.service.impl;

import java.util.List;
import java.util.Optional;

import mate.academy.internetshop.dao.BucketDao;
import mate.academy.internetshop.lib.Inject;
import mate.academy.internetshop.model.Bucket;
import mate.academy.internetshop.model.Item;
import mate.academy.internetshop.service.BucketService;

public class BucketServiceImpl implements BucketService {

    @Inject
    private static BucketDao bucketDao;

    @Override
    public Bucket create(Bucket bucket) {
        return bucketDao.create(bucket);
    }

    @Override
    public Optional<Bucket> get(Long id) {
        return bucketDao.get(id);
    }

    @Override
    public Optional<Bucket> update(Bucket bucket) {
        return bucketDao.update(bucket);
    }

    @Override
    public boolean delete(Long id) {
        return bucketDao.delete(id);
    }

    @Override
    public Bucket addItem(Bucket bucket, Item item) {
        return bucketDao.addItem(bucket, item);
    }

    @Override
    public Bucket deleteItem(Bucket bucket, Item item) {
        return bucketDao.deleteItem(bucket, item);
    }

    @Override
    public Bucket clear(Bucket bucket) {
        return bucketDao.clear(bucket);
    }

    @Override
    public List<Item> getAllItems(Bucket bucket) {
        return bucketDao.getAllItems(bucket);
    }
}
