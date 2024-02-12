package mvcproj.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.ServletContext;
import mvcproj.dao.TodoDao;
import mvcproj.model.Todo;

@Controller
public class HomeCtrl {
    @Autowired
    ServletContext context;
    @Autowired
    TodoDao t1;

    public ServletContext getContext() {
        return context;
    }

    public void setContext(ServletContext context) {
        this.context = context;
    }

    @GetMapping("/home")
    @Transactional
    public String Home(Model m) {
        String str = "HOME";
        m.addAttribute("page", str);

        List<Todo> list = t1.getAllTodo();

        // List<Todo> list = (List<Todo>) context.getAttribute("list");
        m.addAttribute("todos", list);
        return "home";
    }

    @RequestMapping("/add")
    public String addTodo(Model m) {
        Todo t = new Todo();
        m.addAttribute("page", "add");
        m.addAttribute("todo", t);
        return "home";
    }

    @Transactional
    @RequestMapping(value = "/saveTodo", method = RequestMethod.POST)
    public String saveTodo(@ModelAttribute("todo") Todo t, Model m) {
        System.out.println(t);

        t.setTodoDate(new Date());
        // saving to db
        t1.saveTodo(t);
        // get the todo list from context
        List<Todo> list = (List<Todo>) context.getAttribute("list");
        list.add(t);
        m.addAttribute("msg", "successfully added..");
        return "home";
    }

}
