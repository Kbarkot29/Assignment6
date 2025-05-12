import java.util.ArrayList;


public class BevShop implements BevShopInterface {
    public static final int MIN_AGE_FOR_ALCOHOL = 21;
    public static final int MAX_ALCOHOL = 3;

    private int numOfAlcoholInOrder;
    private ArrayList<Order> orders;
    private Order currentOrder;

    public BevShop() {
        orders = new ArrayList<>();
    }

    @Override
    public int getMaxOrderForAlcohol() {
        return 3; // or whatever your assignment says is the max number of alcoholic drinks
    }

    @Override
    public boolean isValidTime(int time) {
        return time >= 8 && time <= 23;
    }

    @Override
    public int getMaxNumOfFruits() {
        return 5;
    }

    @Override
    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > getMaxNumOfFruits();
    }

    @Override
    public boolean isEligibleForMore() {
        return numOfAlcoholInOrder < MAX_ALCOHOL;
    }

    @Override
    public boolean isValidAge(int age) {
        return age >= MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        Customer customer = new Customer(customerName, customerAge);
        currentOrder = new Order(time, day, customer);
        orders.add(currentOrder);
        numOfAlcoholInOrder = 0;
    }

    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    @Override
    public void processAlcoholOrder(String bevName, Size size) {
        currentOrder.addNewBeverage(bevName, size); // use the version that determines weekend internally
        numOfAlcoholInOrder++;
    }


    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
    }

    @Override
    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNo() == orderNo) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo);
        if (index != -1) {
            return orders.get(index).calcOrderTotal();
        }
        return 0;
    }

    @Override
    public double totalMonthlySale() {
        double total = 0;
        for (Order o : orders) {
            total += o.calcOrderTotal();
        }
        return total;
    }

    @Override
    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    @Override
    public Order getCurrentOrder() {
        return currentOrder;
    }

    @Override
    public Order getOrderAtIndex(int index) {
        return orders.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Order o : orders) {
            sb.append(o.toString()).append("\n---------------------\n");
        }
        sb.append("Total Monthly Sale: $").append(totalMonthlySale());
        return sb.toString();
    }

    private boolean isWeekend() {
        Day day = currentOrder.getOrderDay();
        return day == Day.SATURDAY || day == Day.SUNDAY;
    }
    @Override
    public int getNumOfAlcoholDrink() {
        return numOfAlcoholInOrder;
    }

    @Override
    public void sortOrders() {
        for (int i = 0; i < orders.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < orders.size(); j++) {
                if (orders.get(j).compareTo(orders.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Order temp = orders.get(i);
                orders.set(i, orders.get(minIndex));
                orders.set(minIndex, temp);
            }
        }
    }

}
