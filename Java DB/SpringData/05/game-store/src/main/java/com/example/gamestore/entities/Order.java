package com.example.gamestore.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    private User buyer;
    private Set<Game> orderedGames;

    public Order() {
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Game> getOrderedGames() {
        return orderedGames;
    }

    public void setOrderedGames(Set<Game> orderedGames) {
        this.orderedGames = orderedGames;
    }
}
