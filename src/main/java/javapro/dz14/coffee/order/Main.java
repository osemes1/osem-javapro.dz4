package javapro.dz14.coffee.order;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();

        // Додавання початкових замовлень
        Order order1 = new Order();
        order1.setPersonName("Alen");
        orderBoard.add(order1);

        Order order2 = new Order();
        order2.setPersonName("Yoda");
        orderBoard.add(order2);

        Order order3 = new Order();
        order3.setPersonName("Obi-van");
        orderBoard.add(order3);

        Order order4 = new Order();
        order4.setPersonName("John Snow");
        orderBoard.add(order4);

        // Виведення стану черги
        orderBoard.draw();
    }
}
