package todoList.controller;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import todoList.bindingModel.TaskBindingModel;
import todoList.entity.Task;
import todoList.repository.TaskRepository;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TaskController {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<TaskBindingModel> tasks = this.taskRepository.findAll()
                .stream()
                .map(t -> new TaskBindingModel(t.getId(), t.getTitle(), t.getComments()))
                .collect(Collectors.toList());
        model.addAttribute("tasks", tasks);
        model.addAttribute("view", "/task/index");
        return "base-layout";

    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("view", "task/create");
        return "base-layout";
    }

    @PostMapping("/create")
    public String create(Task task, Model model) {
        this.taskRepository.saveAndFlush(task);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Task t = this.taskRepository.findById(id).get();
        TaskBindingModel taskBindingModel =
                new TaskBindingModel(t.getId(), t.getTitle(), t.getComments());
        model.addAttribute("task", taskBindingModel);
        model.addAttribute("view", "task/edit");
        return "base-layout";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, TaskBindingModel model) {
        Task t = this.taskRepository.findById(id).get();
        t.setComments(model.getComments());
        t.setTitle(model.getTitle());
        this.taskRepository.saveAndFlush(t);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") Integer id){
        Task t = this.taskRepository.findById(id).get();
        TaskBindingModel taskBindingModel =
                new TaskBindingModel(t.getId(), t.getTitle(), t.getComments());
        model.addAttribute("task", taskBindingModel);
        model.addAttribute("view", "task/delete");
        return "base-layout";
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.taskRepository.deleteById(id);
        return "redirect:/";

    }
}
