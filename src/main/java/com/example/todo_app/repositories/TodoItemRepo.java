/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.todo_app.repositories;

/**
 *
 * @author FreezinFire
 */
import org.springframework.data.repository.CrudRepository;
import com.example.todo_app.models.TodoItem;

public interface TodoItemRepo extends CrudRepository<TodoItem, Long> {  
}
