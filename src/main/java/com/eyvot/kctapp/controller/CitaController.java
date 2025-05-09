package com.eyvot.kctapp.controller;

import com.eyvot.kctapp.domain.contracts.CitaServiceContract;
import com.eyvot.kctapp.model.Cita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class CitaController {

    @Autowired
    CitaServiceContract citaService;


    @GetMapping("/")
    public String listarCitas(Model model) {
        List<Cita> citas = citaService.obtenerCitas();
        model.addAttribute("citas", citas);
        return "index";
    }

}
