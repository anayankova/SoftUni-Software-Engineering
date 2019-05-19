package com.softuni.ebank.controllers;

import com.softuni.ebank.bindingModels.BankAccountBindingModel;
import com.softuni.ebank.entities.BankAccount;
import com.softuni.ebank.services.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.SecondaryTable;
import java.security.Principal;
import java.util.Set;

@Controller
@RequestMapping("/accounts")
public class BankAccountController {
    private final BankAccountService bankAccountService;

    @Autowired
    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/create")
    @PreAuthorize("isAuthenticated()")
    public String createBankAccount(Model model, @ModelAttribute("bankAccountBindingModel")
            BankAccountBindingModel bankAccountBindingModel, Principal principal) {
        bankAccountBindingModel.setUsername(principal.getName());
        model.addAttribute("view", "accounts/create-account");
        model.addAttribute("bankAccountBindingModel", bankAccountBindingModel);

        return "fragments/layout";
    }

    @PostMapping("/create")
    @PreAuthorize("isAuthenticated()")
    public String createBankAccountConfirm(Model model, @ModelAttribute("bankAccountBindingModel")
            BankAccountBindingModel bankAccountBindingModel) {

        if (!this.bankAccountService.createAccoount(bankAccountBindingModel)) {
            model.addAttribute("view", "accounts/create-account");
            model.addAttribute("bankAccountBindingModel", bankAccountBindingModel);
            return "fragments/layout";
        }

        return "redirect:/home";
    }

    @GetMapping("/deposit/{id}")
    @PreAuthorize("isAuthenticated()")
    public String deposit(@PathVariable("id") Long id, Model model) {
        BankAccountBindingModel bankAccountBindingModel = this.bankAccountService.getOneForProcess(id);
        model.addAttribute("bankAccountBindingModel", bankAccountBindingModel);
        model.addAttribute("view", "accounts/deposit");

        return "fragments/layout";
    }

    @PostMapping("/deposit/{id}")
    @PreAuthorize("isAuthenticated()")
    public String depositConfirm(@PathVariable("id") Long id, Model model,
                                 @ModelAttribute("bankAccountBindingModel") BankAccountBindingModel bankAccountBindingModel) {
        if (!this.bankAccountService.depositAmount(bankAccountBindingModel)) {
            model.addAttribute("bankAccountBindingModel", bankAccountBindingModel);
            model.addAttribute("view", "accounts/deposit");

            return "fragments/layout";
        }
        return "redirect:/home";
    }

    @GetMapping("/withdraw/{id}")
    @PreAuthorize("isAuthenticated()")
    public String withdraw(@PathVariable("id") Long id, Model model) {
        BankAccountBindingModel bankAccountBindingModel = this.bankAccountService.getOneForProcess(id);
        model.addAttribute("bankAccountBindingModel", bankAccountBindingModel);
        model.addAttribute("view", "accounts/withdraw");

        return "fragments/layout";
    }

    @PostMapping("/withdraw/{id}")
    @PreAuthorize("isAuthenticated()")
    public String withdrawConfirm(@PathVariable("id") Long id, Model model,
                                 @ModelAttribute("bankAccountBindingModel") BankAccountBindingModel bankAccountBindingModel) {
        if (!this.bankAccountService.withdrawAmount(bankAccountBindingModel)) {
            model.addAttribute("bankAccountBindingModel", bankAccountBindingModel);
            model.addAttribute("view", "accounts/withdraw");

            return "fragments/layout";
        }
        return "redirect:/home";
    }

    @GetMapping("/transfer/{id}")
    @PreAuthorize("isAuthenticated()")
    public String transfer(@PathVariable("id") Long id, Model model) {
        BankAccountBindingModel bankAccountBindingModel = this.bankAccountService.getOneForProcess(id);
        model.addAttribute("bankAccountBindingModel", bankAccountBindingModel);
        model.addAttribute("bankAccounts", this.bankAccountService.getAllById(id));
        model.addAttribute("view", "accounts/transfer");

        return "fragments/layout";
    }

    @PostMapping("/transfer/{id}")
    @PreAuthorize("isAuthenticated()")
    public String transferConfirm(@PathVariable("id") Long id, Model model,
                                  @ModelAttribute("bankAccountBindingModel") BankAccountBindingModel bankAccountBindingModel) {
        if (!this.bankAccountService.transferAmount(bankAccountBindingModel)) {
            model.addAttribute("bankAccountBindingModel", bankAccountBindingModel);

            model.addAttribute("bankAccounts", this.bankAccountService.getAllById(id));
            model.addAttribute("view", "accounts/transfer");
            return "fragments/layout";

        }
        return "redirect:/home";
    }
}
