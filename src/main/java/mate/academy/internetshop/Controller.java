package mate.academy.internetshop;

import mate.academy.internetshop.lib.Inject;
import mate.academy.internetshop.lib.Injector;
import mate.academy.internetshop.model.Bucket;
import mate.academy.internetshop.model.Item;
import mate.academy.internetshop.model.User;
import mate.academy.internetshop.service.BucketService;
import mate.academy.internetshop.service.ItemService;
import mate.academy.internetshop.service.OrderService;
import mate.academy.internetshop.service.UserService;

public class Controller {

    @Inject
    public static BucketService bucketService;
    @Inject
    public static UserService userService;
    @Inject
    public static ItemService itemService;
    @Inject
    public static OrderService orderService;

    static {
        try {
            Injector.injectDependency();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Bucket newBucket = new Bucket();
        Item laptop = new Item("Apple", 1250.50);
        Item smartphone = new Item("Samsung", 400D);
        User newUser = new User("Alex");

        bucketService.create(newBucket);
        userService.create(newUser);

        itemService.create(laptop);
        bucketService.addItem(newBucket, laptop);
        itemService.create(smartphone);
        bucketService.addItem(newBucket, smartphone);

        orderService.completeOrder(newBucket.getItemsInBucket(), newUser);

        bucketService.deleteItem(newBucket, smartphone);

        orderService.completeOrder(newBucket.getItemsInBucket(), newUser);

        orderService.getUserOrders(newUser);
    }
}
