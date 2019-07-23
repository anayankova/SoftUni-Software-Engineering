package c_Encapsulation.pizza;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String type, double weight) {
        this.setToppingType(type);
        this.setWeight(weight);
    }

    private void setWeight(double weight) {
        Validator.validateToppingWeight(this.toppingType, weight);
        this.weight = weight;

    }

    private void setToppingType(String type) {
        Validator.validateToppingType(type);
        this.toppingType = type;
    }

    public double calculateCalories() {
        double calories = 2 * this.weight;

        switch (this.toppingType) {
            case "Meat":
                calories *= 1.2;
                break;
            case "Veggies":
                calories *= 0.8;
                break;
            case "Cheese":
                calories *= 1.1;
                break;
            default:
                calories *= 0.9;
                break;
        }

        return calories;
    }
}
