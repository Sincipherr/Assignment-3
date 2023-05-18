package com.geekster.RandomJokes.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class JokesController {
    static ArrayList<String>jokesList=new ArrayList<>();
    @GetMapping(value ="/jokes")
    public String jokes(){

//        jokesList.add("What did the snail who was riding on the turtle's back say?\n"+"\n"+"Wheeeee!");
//        jokesList.add("how do you call a lazy kangaroo?\n"+"\n"+"A pouch potato.");
//        jokesList.add("when do we tell actors to \"break a leg?\n"+"\n"+"Because every play has a cast.");
//        jokesList.add("do you call it when a snowman throws a tantrum?\n"+"\n"+"A meltdown.");
        int random=0+(int)(Math.random()*((4-0)+1));
        return jokesList.get(random);
    }

    @PostMapping(value = "/jokes")
    public String savejokes(@RequestBody String newjoke){
        jokesList.add(newjoke);
        return  "Saved joke";
    }
}
