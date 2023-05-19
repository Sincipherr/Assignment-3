package com.geekster.TodoApp.Repository;

import com.geekster.TodoApp.Models.Todo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoRepo {
    private List<Todo> todolist;
    public TodoRepo(){
        todolist=new ArrayList<>();
        todolist.add(new Todo("0","Dummy",true));
    }
    public List<Todo> getentry(){
        return todolist;
    }
    public boolean save(Todo todo){
        todolist.add(todo);
        return true;
    }
    public boolean removetodo(Todo todo){
        todolist.remove(todo);
        return true;
    }
    public boolean update(String id,boolean status){
        boolean updatestatus=false;
        for (Todo todo:todolist){
            if(todo.getID().equals(id)){
                //remove original
                removetodo(todo);
                //update the todo
                todo.setTodostatus(status);
                save(todo);
                return true;//not changing database
            }
        }
        return false;
    }
}
