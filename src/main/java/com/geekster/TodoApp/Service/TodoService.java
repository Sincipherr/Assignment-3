package com.geekster.TodoApp.Service;

import com.geekster.TodoApp.Repository.TodoRepo;
import com.geekster.TodoApp.Models.Todo;
import jdk.jshell.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    @Autowired
   TodoRepo tp;

    public List<Todo> getAllentry(){
        return tp.getentry();
    }
    public String addMytodo(Todo todo){
        boolean Insert=tp.save(todo);
        if(Insert){
            return "Todo added successfully";
        }
        return "Failed ... Todo Not possible";
    }
    public Todo specificID(String id){
        List <Todo > todorightnow=tp.getentry();
        for(Todo todo:todorightnow){
            if(todo.getID().equals(id)){
                return todo;
            }
        }
        return  null;
    }
    public String deletetodo(String id){
        boolean deleteresponse=false;
        String status;
        if(id!=null){
            List <Todo > todorightnow=tp.getentry();
            for(Todo todo:todorightnow){
                if(todo.getID().equals(id)){
                    deleteresponse=tp.removetodo(todo);
                    if(deleteresponse){
                        status="Todo with ID "+id+" was deleted";
                    }else{
                        status="Todo with ID "+id+" was not deleted!!!! .. Database error";
                    }
                    return status;
                }
            }
            return "Todo with ID "+id+" doest not exist";
        }
        return "Invalid ID... ID  is not present";
    }
    public String updatetodoid(String id,String status){
        boolean updatestatus=tp.update(id, Boolean.parseBoolean(status));
        if(updatestatus){
            return "Todo with ID "+id+" got updated";
        }
        return "Todo with ID "+id+" doest not exist";
    }
    public List<Todo> getfilter(String status){
        List <Todo > todorightnow=tp.getentry();
        List <Todo > todostatus=new ArrayList<>();
        for(Todo todo:todorightnow){
            if(todo.isTodostatus()==Boolean.parseBoolean(status)){
                todostatus.add(todo);
            }
        }
        return todostatus;
    }
}
