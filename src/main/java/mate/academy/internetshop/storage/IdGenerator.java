package mate.academy.internetshop.storage;

public class IdGenerator {
    private static long itemId = 0;
    private static long userId = 0;
    private static long bucketId = 0;
    private static long orderId = 0;

    public static Long getItemId() {
        return itemId++;
    }

    public static Long getUserId() {
        return userId++;
    }

    public static Long getBucketId() {
        return bucketId++;
    }

    public static Long getOrderId() {
        return orderId++;
    }
}
