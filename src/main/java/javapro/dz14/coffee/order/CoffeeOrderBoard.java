package javapro.dz14.coffee.order;

import java.util.ArrayList;
import java.util.List;

public class CoffeeOrderBoard {
    private List<Order> orderList;
    private int lastOrderNumber;

    public CoffeeOrderBoard() {
        orderList = new ArrayList<>();
        lastOrderNumber = 0;
    }

    public void add(Order order) {
        order.setOrderNumber(++lastOrderNumber);
        orderList.add(order);
    }

    public Order deliver() {
        if (orderList.isEmpty()) {
            return null;
        }
        Order nextOrder = orderList.get(0);
        orderList.remove(0);
        return nextOrder;
    }

    public Order deliver(int orderNumber) {
        for (int i = 0; i < orderList.size(); i++) {
            Order order = orderList.get(i);
            if (order.getOrderNumber() == orderNumber) {
                orderList.remove(i);
                return order;
            }
        }
        return null;
    }

    public void draw() {
        System.out.println("Num | Name");
        for (Order order : orderList) {
            System.out.println(order.getOrderNumber() + " | " + order.getPersonName());
        }
    }
}
