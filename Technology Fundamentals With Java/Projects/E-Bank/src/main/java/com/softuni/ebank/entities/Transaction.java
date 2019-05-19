package com.softuni.ebank.entities;

import javax.persistence.*;
import java.lang.annotation.Target;
import java.math.BigDecimal;

@Entity
@Table(name = "transactions")
public class Transaction {

    private Long id;
    private String type;
    private BankAccount fromAccount;
    private BankAccount toAccount;
    private BigDecimal amount;

    public Transaction() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "transaction_type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @ManyToOne(targetEntity = BankAccount.class)
    @JoinColumn(name = "sender", updatable = false)
    public BankAccount getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(BankAccount fromAccount) {
        this.fromAccount = fromAccount;
    }

    @ManyToOne(targetEntity = BankAccount.class)
    @JoinColumn(name = "receiver", updatable = false)
    public BankAccount getToAccount() {
        return toAccount;
    }

    public void setToAccount(BankAccount toAccount) {
        this.toAccount = toAccount;
    }

    @Column(name = "amount", updatable = false, nullable = false)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
