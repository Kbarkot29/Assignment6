
import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order> {
    private int orderNo;
    private int orderTime;
    private Day orderDay;
    private Customer customer;
    private ArrayList<Beverage> beverages;

    public static final int MIN_ORDER_NO = 10000;
    public static final int MAX_ORDER_NO = 90000;

    public Order(int orderTime, Day orderDay, Customer customer) {
        this.orderNo = generateOrder();
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = new Customer(customer); // Deep copy
        this.beverages = new ArrayList<>();
    }

    private int generateOrder() {
        return new Random().nextInt(MAX_ORDER_NO - MIN_ORDER_NO + 1) + MIN_ORDER_NO;
    }

    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
    }

    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }

    public void setCustomer(Customer customer) {
        this.customer = new Customer(customer);
    }

    public double calcOrderTotal() {
        double total = 0;
        for (Beverage b : beverages) {
            total += b.calcPrice();
        }
        return total;
    }

    @Override
    public int compareTo(Order other) {
        return Integer.compare(this.orderNo, other.orderNo);
    }

    public int getOrderNo() {
        return orderNo;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public Day getOrderDay() {
        return orderDay;
    }

    public Customer getCustomer() {
        return new Customer(customer);
    }

    public ArrayList<Beverage> getBeverages() {
        return beverages;
    }

    public int getTotalItems() {
        return beverages.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order #: ").append(orderNo).append(", Time: ").append(orderTime)
          .append(", Day: ").append(orderDay).append(", Customer: ").append(customer).append("\n");
        for (Beverage b : beverages) {
            sb.append(b).append("\n");
        }
        sb.append("Total: $").append(calcOrderTotal());
        return sb.toString();
    }
    @Override
    public Beverage getBeverage(int itemNo) {
        if (itemNo >= 0 && itemNo < beverages.size()) {
            return beverages.get(itemNo);
        }
        return null;
    }
    @Override
    public boolean isWeekend() {
        return orderDay == Day.SATURDAY || orderDay == Day.SUNDAY;
    }

    @Override
    public int findNumOfBeveType(Type type) {
        int count = 0;
        for (Beverage b : beverages) {
            if (b.getType() == type) {
                count++;
            }
        }
        return count;
    }
    @Override
    public void addNewBeverage(String bevName, Size size) {
        // Assume current orderDay determines weekend or not
        boolean isWeekend = (orderDay == Day.SATURDAY || orderDay == Day.SUNDAY);
        beverages.add(new Alcohol(bevName, size, isWeekend));
    }



}

