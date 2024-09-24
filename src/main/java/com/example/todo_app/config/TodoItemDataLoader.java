/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.todo_app.config;

import com.example.todo_app.repositories.TodoItemRepo;
import com.example.todo_app.models.TodoItem;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author FreezinFire
 */
@Component
public class TodoItemDataLoader implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(TodoItemDataLoader.class);
    
    @Autowired
    TodoItemRepo todoItemRepo;
    
    @Override
    public void run(String... args) throws Exception{
        loadSeedData();
    }
    
    private void loadSeedData(){
        if(todoItemRepo.count() == 0){
            TodoItem todoItem = new TodoItem("Sample Task");
            
            todoItemRepo.save(todoItem);
        }
        
        logger.info("Total TodoItems:{}", todoItemRepo.count());
    }
}
