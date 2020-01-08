package mate.academy.internetshop.model;

import java.util.ArrayList;
import java.util.List;

public class Bucket {
    private Long id;
    private Long orderId;
    private List<Item> itemsInBucket;

    public Bucket() {
        this.itemsInBucket = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItemsInBucket() {
        return itemsInBucket;
    }

    public void setItemsInBucket(List<Item> itemsInBucket) {
        this.itemsInBucket = itemsInBucket;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
