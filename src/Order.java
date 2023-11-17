import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private String orderDate;
    private int totalAmount;
    private String customerName;
    private String customerPhone;

    private List<OrderDetails> items;
    private boolean status = false; // chua duyet

    public Order(int id, String orderDate, String customerName, String customerPhone) {
        this.id = id;
        this.orderDate = orderDate;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.items = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void calculateTotalAmount() {
        // Duyet orderItems -> price * quantity
        int t = 0;
        for (OrderDetails orderDetail : items) {
            t += orderDetail.getQuantity() * orderDetail.getItem().getPrice();
        }
        totalAmount = t;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public List<OrderDetails> getItems() {
        return items;
    }

    public void setItems(List<OrderDetails> items) {
        this.items = items;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void printOrder() {
        System.out.println("---------------------------------------------------");
        System.out.println("Ma hoa don - " + id);
        System.out.printf("Nguoi nhan: %s - %s \n", customerName, customerPhone);
        System.out.println("Tong tien: " + totalAmount);
        System.out.println("Trang thai: " + ((status == true) ? "Da duyet" : "Chua duyet"));
        // In ra danh sach san pham - so luong - thanh tien
        System.out.println("Ma SP \t Ten san pham \t So luong \t Gia tien \t Thanh tien");
        for (OrderDetails orderDetail : items) {
            Product product = orderDetail.getItem();
            System.out.print(product.getId() + "\t");
            System.out.print(product.getName() + "\t");
            System.out.print(orderDetail.getQuantity() + "\t");
            System.out.print(product.getPrice()+"\t");
            System.out.print(orderDetail.getQuantity() * product.getPrice()+"\n");
        }
        System.out.println("---------------------------------------------------");
    }
}
