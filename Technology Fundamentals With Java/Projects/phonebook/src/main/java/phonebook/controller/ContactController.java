package phonebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import phonebook.entity.Contact;
import phonebook.entity.ContactBindingModel;
import phonebook.util.CrazyMapper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ContactController {

    private List<Contact> contacts;

    public ContactController() {
        this.contacts = new ArrayList<>();
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("contacts",this.contacts);
        return "index";
    }

    @PostMapping("/")
    public String addContact(ContactBindingModel bindingModel){
        try {
            Contact contact = CrazyMapper.createMapping(bindingModel,Contact.class);
            this.contacts.add(contact);
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchFieldException e) {
            e.printStackTrace();
        }

        return "redirect:/";
    }
}
