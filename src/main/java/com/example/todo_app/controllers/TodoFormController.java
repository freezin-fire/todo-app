/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.todo_app.controllers;

import com.example.todo_app.repositories.TodoItemRepo;
import com.example.todo_app.models.TodoItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author FreezinFire
 */
@Controller
public class TodoFormController {
    
    @Autowired
    private TodoItemRepo todoItemRepo;
    
    @GetMapping("/create-todo")
    public String showCreateForm(TodoItem todoItem){
        return "add-todo-item";
    }
    
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model){
        TodoItem todoItem = todoItemRepo
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));
        
        model.addAttribute("todo", todoItem);
        return "update-todo-item";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") long id, Model model) {
        TodoItem todoItem = todoItemRepo
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));
    
        todoItemRepo.delete(todoItem);
        return "redirect:/";
    }
}
