package c_Encapsulation.ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().isEmpty() || name.equals(null)) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (this.money >= product.getCost()) {
            this.products.add(product);
            this.money -= product.getCost();
            System.out.println(String.format(
                    "%s bought %s",
                    this.getName(), product.getName()));
        } else {
            System.out.println(String.format(
                    "%s can't afford %s",
                    this.getName(), product.getName()));
        }
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        if (this.products.isEmpty()) {
            return String.format("%s – Nothing bought",this.getName());
        } else {
            String result = this.getName() + " - ";
            for (int i = 0; i < this.products.size(); i++) {
                if (i != this.products.size() - 1) {
                    result += this.products.get(i).getName() + ", ";
                } else {
                    result += this.products.get(i).getName();
                }
            }
            return result;
        }
    }
}
