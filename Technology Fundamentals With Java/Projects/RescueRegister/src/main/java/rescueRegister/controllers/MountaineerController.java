package rescueRegister.controllers;

import rescueRegister.bindingModels.MountaineerBindingModel;
import rescueRegister.entities.Mountaineer;
import rescueRegister.repositories.MountaineerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MountaineerController {
    private final MountaineerRepository mountaineerRepository;

    @Autowired
    public MountaineerController(MountaineerRepository mountaineerRepository) {
        this.mountaineerRepository = mountaineerRepository;
    }


    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.addObject("view", "mountaineer/index");
        modelAndView.addObject("mountaineers", this.mountaineerRepository.findAll());

        modelAndView.setViewName("base-layout");
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create(ModelAndView modelAndView) {
        modelAndView.addObject("view", "mountaineer/create");

        modelAndView.setViewName("base-layout");
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(Mountaineer mountaineer) {
        this.mountaineerRepository.save(mountaineer);

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable(value = "id") Integer id, ModelAndView modelAndView) {
        modelAndView.addObject("view", "mountaineer/edit");
        modelAndView.addObject("mountaineer", this.mountaineerRepository.getOne(id));

        modelAndView.setViewName("base-layout");
        return modelAndView;
    }

    @PostMapping("edit/{id}")
    public String edit(@PathVariable(value = "id") Integer id, MountaineerBindingModel MountaineerBindingModel) {
        Mountaineer mountaineerToEdit = this.mountaineerRepository.getOne(id);

        mountaineerToEdit.setName(MountaineerBindingModel.getName());
        mountaineerToEdit.setAge(MountaineerBindingModel.getAge());
        mountaineerToEdit.setGender(MountaineerBindingModel.getGender());
        mountaineerToEdit.setLastSeenDate(MountaineerBindingModel.getLastSeenDate());

        this.mountaineerRepository.saveAndFlush(mountaineerToEdit);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView remove(@PathVariable(value = "id") Integer id, ModelAndView modelAndView) {
        modelAndView.addObject("view", "mountaineer/remove");
        modelAndView.addObject("mountaineer", this.mountaineerRepository.getOne(id));

        modelAndView.setViewName("base-layout");
        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public String remove(Mountaineer mountaineer) {
        this.mountaineerRepository.delete(mountaineer);

        return "redirect:/";
    }
}
