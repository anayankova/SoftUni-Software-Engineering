package meisterTask.controllers;

import meisterTask.bindingModel.TaskBindingModel;
import meisterTask.entities.Task;
import meisterTask.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView index(ModelAndView modelAndView) {
        //List<Article>articles = this.articleRepository.findAll();

        List<Task> openTasks = this.taskRepository.findAllByStatus("Open");
        List<Task> inProgressTasks = this.taskRepository.findAllByStatus("In Progress");
        List<Task> finishedTasks = this.taskRepository.findAllByStatus("Finished");

        //List<Task> finishedTasks = this.taskRepository
                //.findAll()
                //.stream()
                //.filter(e -> e.getStatus().equals("Finished"))
                //.collect(Collectors.toList());

        modelAndView.setViewName("base-layout");
        modelAndView.addObject("view","task/index");
        modelAndView.addObject("openTasks",openTasks);
        modelAndView.addObject("inProgressTasks",inProgressTasks);
        modelAndView.addObject("finishedTasks",finishedTasks);

        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create(ModelAndView modelAndView) {
        modelAndView.setViewName("base-layout");
        modelAndView.addObject("view","task/create");
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(TaskBindingModel taskBindingModel) {
        Task task = new Task(
                taskBindingModel.getTitle(),
                taskBindingModel.getStatus()
        );
      this.taskRepository.saveAndFlush(task);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(ModelAndView modelAndView,
                             @PathVariable(value = "id") Integer id) {

        Task task = this.taskRepository.getOne(id);
        modelAndView.setViewName("base-layout");
        modelAndView.addObject("view","task/edit");
        modelAndView.addObject("task",task);

        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public String edit(TaskBindingModel taskBindingModel,
                       @PathVariable(value = "id") Integer id) {
        Task task = this.taskRepository.getOne(id);
        task.setTitle(taskBindingModel.getTitle());
        task.setStatus(taskBindingModel.getStatus());

        this.taskRepository.saveAndFlush(task);

       return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(ModelAndView modelAndView,
                             @PathVariable(value = "id") Integer id) {

        Task task = this.taskRepository.getOne(id);
        modelAndView.setViewName("base-layout");
        modelAndView.addObject("view","task/delete");
        modelAndView.addObject("task",task);

        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public String delete(Task task) {
       this.taskRepository.delete(task);

        return "redirect:/";
    }
}
