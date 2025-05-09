package com.eyvot.kctapp.controller;

import com.eyvot.kctapp.domain.contracts.CitaServiceContract;
import com.eyvot.kctapp.domain.contracts.ConsultorioServiceContract;
import com.eyvot.kctapp.domain.contracts.DoctorServiceContract;
import com.eyvot.kctapp.model.Cita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class CitaController {

    @Autowired CitaServiceContract citaService;
    @Autowired DoctorServiceContract doctorService;
    @Autowired ConsultorioServiceContract consultorioService;


    @GetMapping("/")
    public String listarCitas(Model model) {
        List<Cita> citas = citaService.obtenerCitas();
        model.addAttribute("citas", citas);
        return "index";
    }

    @GetMapping("/citas/nueva")
    public String mostrarFormulario(Model model) {
        model.addAttribute("cita", new Cita());
        model.addAttribute("doctores", doctorService.obtenerDoctores());
        model.addAttribute("consultorios", consultorioService.obtenerConsultorios());
        return "nueva-cita";
    }

    @PostMapping("/citas")
    public String registrarCita(@ModelAttribute("cita") Cita cita, Model model) {
        String error = citaService.agendarCita(cita);
        if (error != null) {
            model.addAttribute("error", error);
            model.addAttribute("doctores", doctorService.obtenerDoctores());
            model.addAttribute("consultorios", consultorioService.obtenerConsultorios());
            return "nueva-cita";
        }
        return "redirect:/";
    }

}
