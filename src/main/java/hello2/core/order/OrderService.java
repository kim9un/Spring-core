package hello2.core.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPirce);
}
