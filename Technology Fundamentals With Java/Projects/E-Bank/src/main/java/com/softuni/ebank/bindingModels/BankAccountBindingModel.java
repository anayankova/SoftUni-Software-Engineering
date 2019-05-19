package com.softuni.ebank.bindingModels;

import org.springframework.lang.NonNull;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

public class BankAccountBindingModel {
    private Long id;
    private String username;
    private String iban;
    private BigDecimal amount;
    private Long recieverId;

    public BankAccountBindingModel() {
    }

    public BankAccountBindingModel(Long id, String username, String iban, BigDecimal amount, Long recieverId) {
        this.id = id;
        this.username = username;
        this.iban = iban;
        this.amount = amount;
        this.recieverId = recieverId;
    }

    @NonNull
    @NotEmpty
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotEmpty
    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getRecieverId() {
        return recieverId;
    }

    public void setRecieverId(Long recieverId) {
        this.recieverId = recieverId;
    }
}
