package com.geekster.TodoApp.Controller;

import com.geekster.TodoApp.Models.Todo;
import com.geekster.TodoApp.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    TodoService ts;

    @GetMapping(value = "/getTodo")
    public List<Todo> getAlltodo(){
        return ts.getAllentry();
    }

    @PostMapping(value = "/addTodo")
    public String addTodo(@RequestBody Todo todo){
        return ts.addMytodo(todo);
    }

    @GetMapping(value = "/getSpe/{id}")
    public Todo getspecific(@PathVariable String id){
        return ts.specificID(id);
        //http://localhost:8082/getSpe/0
    }
    @DeleteMapping(value = "/deletetodo/{id}")
    public String deleteTodo(@PathVariable String id){
        return ts.deletetodo(id);
        //http://localhost:8082/deletetodo/6
    }

    @PutMapping(value = "/updatetodo/{id}/{status}")
    public String updatetodo(@PathVariable String id,@PathVariable String status){
        return ts.updatetodoid(id,status);
        //http://localhost:8082/updatetodo/0/false
    }

    @GetMapping(value = "/getfilter")
    public List<Todo> getfilter(@RequestParam String status){
        return ts.getfilter(status);
        //http://localhost:8082/getfilter?status=false
    }
}
