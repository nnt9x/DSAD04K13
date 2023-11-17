public class Main {
    public static void main(String[] args) {
        // San pham
        Product product1 = new Product(1, "San pham 1", 1000);
        Product product2 = new Product(2, "San pham 2", 2000);

        Product product3 = new Product(3, "San pham 3", 3000);
        Product product4 = new Product(4, "San pham 4", 4000);

        Product product5 = new Product(5, "San pham 5", 5000);

        // Tao hoa don
        Order order1 = new Order(1, "2023-10-10","Customer 1", "122333");
        order1.getItems().add(new OrderDetails(1, product1, 3));
        order1.getItems().add(new OrderDetails(2, product2, 4));

        order1.calculateTotalAmount();

        Order order2 = new Order(2, "2023-10-11","Customer 2", "122334");
        order2.getItems().add(new OrderDetails(1, product5, 1));
        order2.getItems().add(new OrderDetails(2, product4, 2));
        order2.calculateTotalAmount();

        // Demo -> order 2 them truoc va order 1 them sau
        QueueADT<Order> orderQueueADT = new QueueADTImpl<>(100);
        orderQueueADT.enqueue(order2);
        orderQueueADT.enqueue(order1);
        // Duyet hoa don
        while (!orderQueueADT.isEmpty()){
            Order o = orderQueueADT.dequeue();
            o.setStatus(true);
            o.printOrder();
        }


    }
}
