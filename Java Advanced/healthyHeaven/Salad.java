package healthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Salad {
    private List<Vegetable> products;
    private String name;

    public Salad(String name) {
        this.products = new ArrayList<>();
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getTotalCalories() {
        return this.products.stream().mapToInt(Vegetable::getCalories).sum();
    }

    public int getProductCount() {
        return this.products.size();
    }

    public void add(Vegetable product) {
        this.products.add(product);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("* Salad %s is %d calories and have %d products:",
                this.getName(),
                this.getTotalCalories(),
                this.getProductCount()));
        sb.append(System.lineSeparator());
        for (int i = 0; i < this.products.size(); i++) {
            if (i != this.products.size() - 1) {
                sb.append(this.products.get(i)).append(System.lineSeparator());
            } else {
                sb.append(this.products.get(i));
            }
        }
        return sb.toString();
    }
}
