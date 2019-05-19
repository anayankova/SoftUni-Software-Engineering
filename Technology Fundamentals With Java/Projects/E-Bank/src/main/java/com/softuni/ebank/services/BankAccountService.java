package com.softuni.ebank.services;

import com.softuni.ebank.bindingModels.BankAccountBindingModel;
import com.softuni.ebank.entities.BankAccount;
import com.softuni.ebank.entities.Transaction;
import com.softuni.ebank.entities.User;
import com.softuni.ebank.repositories.BankAccountRepository;
import com.softuni.ebank.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BankAccountService {
    private final BankAccountRepository bankAccountRepository;
    private final TransactionRepository transactionRepository;
    private final UserService userService;

    @Autowired
    public BankAccountService(BankAccountRepository bankAccountRepository,
                              TransactionRepository transactionRepository, UserService userService) {
        this.bankAccountRepository = bankAccountRepository;
        this.transactionRepository = transactionRepository;
        this.userService = userService;
    }

    public Set<BankAccount> findAllByOwnerUsername(Principal principal) {
        Set<BankAccount> bankAccounts = this.bankAccountRepository
                .findAllByOwnerUsername(principal.getName());

        return bankAccounts;
    }

    public boolean createAccoount(BankAccountBindingModel model){

        BankAccount account = this.bankAccountRepository.findByIban(model.getIban());

        if (account != null){
            return false;
        }
        account = new BankAccount();

        User user = this.userService.findOneByUserName(model.getUsername());

        account.setIban(model.getIban());

        if(user == null){
            return false;
        }
        account.setOwner(user);
        account.setBalance(BigDecimal.ZERO);

        return this.bankAccountRepository.saveAndFlush(account) != null;
    }

    public BankAccountBindingModel getOneForProcess(Long accountId){
        BankAccount bankAccount = this.bankAccountRepository.findById(accountId).orElse(null);

        if (bankAccount == null){
            throw new IllegalArgumentException("Invalid account");
        }

        BankAccountBindingModel model = new BankAccountBindingModel();
        model.setId(accountId);
        model.setUsername(bankAccount.getOwner().getUsername());
        model.setIban(bankAccount.getIban());

        return model;
    }

    public boolean depositAmount(BankAccountBindingModel model){
        BankAccount bankAccount = this.bankAccountRepository.findById(model.getId()).orElse(null);

        if(bankAccount == null){
            return false;
        }else if(BigDecimal.ZERO.compareTo(model.getAmount()) > 0){
            return false;
        }

        bankAccount.setBalance(bankAccount.getBalance().add(model.getAmount()));

        Transaction transaction = new Transaction();
        transaction.setFromAccount(bankAccount);
        transaction.setToAccount(bankAccount);
        transaction.setAmount(model.getAmount());
        transaction.setType("DEPOSIT");

        this.transactionRepository.save(transaction);

        return this.bankAccountRepository.saveAndFlush(bankAccount) != null;
    }

    public boolean withdrawAmount(BankAccountBindingModel model){
        BankAccount bankAccount = this.bankAccountRepository.findById(model.getId()).orElse(null);

        if(bankAccount == null){
            return false;
        }else if(BigDecimal.ZERO.compareTo(model.getAmount()) > 0){
            return false;
        }else if(bankAccount.getBalance().compareTo(model.getAmount()) < 0){
            return false;
        }

        bankAccount.setBalance(bankAccount.getBalance().subtract(model.getAmount()));

        Transaction transaction = new Transaction();
        transaction.setFromAccount(bankAccount);
        transaction.setToAccount(bankAccount);
        transaction.setAmount(model.getAmount());
        transaction.setType("WITHDRAW");

        this.transactionRepository.save(transaction);

        return this.bankAccountRepository.saveAndFlush(bankAccount) != null;
    }

    public boolean transferAmount(BankAccountBindingModel model){
        BankAccount fromAccount = this.bankAccountRepository.findById(model.getId()).orElse(null);
        BankAccount toAccount = this.bankAccountRepository.findById(model.getRecieverId()).orElse(null);

        if(fromAccount == null || toAccount == null){
            return false;
        }else if(BigDecimal.ZERO.compareTo(model.getAmount()) > 0){
            return false;
        }

        if(fromAccount.getBalance().compareTo(model.getAmount()) < 0){
            return false;
        }

        BigDecimal newBalance = toAccount.getBalance().add(model.getAmount());
        toAccount.setBalance(newBalance);

        fromAccount.setBalance(fromAccount.getBalance().subtract(model.getAmount()));

        Transaction transaction = new Transaction();
        transaction.setFromAccount(fromAccount);
        transaction.setToAccount(toAccount);
        transaction.setAmount(model.getAmount());
        transaction.setType("TRANSFER");

        this.transactionRepository.save(transaction);

        return this.bankAccountRepository.saveAndFlush(fromAccount) != null
                && this.bankAccountRepository.saveAndFlush(toAccount) != null;
    }

    public List<BankAccount> getAllById(Long id){
       return this.bankAccountRepository.findAllByIdIsNot(id);

    }
}


