
public abstract class Beverage {

	private String name;
    private Type type;
    private Size size;

    public static final double BASE_PRICE = 2.0;
    public static final double SIZE_PRICE = 0.5;

    public Beverage(String name, Type type, Size size) {
        this.name = name;
        this.type = type;
        this.size = size;
    }

    public double addSizePrice() {
        switch (size) {
            case MEDIUM:
                return SIZE_PRICE;
            case LARGE:
                return 2 * SIZE_PRICE;
            default:
                return 0.0;
        }
    }

    public abstract double calcPrice();

    public String toString() {
        return name + ", " + size;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Beverage other = (Beverage) obj;
        return name.equals(other.name) && type == other.type && size == other.size;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}


