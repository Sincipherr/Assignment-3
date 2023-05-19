package com.geekster.TodoApp.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Todo {
    private String ID;
//    @JsonProperty("todoName") //it will work for both todoName and todoname
    private String todoname;
    private boolean todostatus;
//    public Todo(String ID, String todoname, boolean todostatus) {
//        this.ID = ID;
//        this.todoname = todoname;
//        this.todostatus = todostatus;
//    }
//    public String getID() {
//        return ID;
//    }
//    public void setID(String ID) {
//        this.ID = ID;
//    }
//    public void setTodoname(String todoname) {
//        this.todoname = todoname;
//    }
//    public void setTodostatus(boolean todostatus) {
//        this.todostatus = todostatus;
//    }
//    public String getTodoname() {
//        return todoname;
//    }
//    public boolean isTodostatus() {
//        return todostatus;
//    }
}
