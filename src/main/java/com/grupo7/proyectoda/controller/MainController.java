package com.grupo7.proyectoda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/tareas")
    public String tareas() {
        return "tareas";
    }
}
