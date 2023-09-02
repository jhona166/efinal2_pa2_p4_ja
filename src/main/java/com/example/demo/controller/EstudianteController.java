package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {
	@Autowired
	private IEstudianteService iEstudianteService;
	@GetMapping("/inicio")
	public String mostrarInicioEstudiante() {

		return "vistaInicioEstudiante";

	}
	
	//http://localhost:8080/escuela/estudiantes/insertarEstudiante
	@GetMapping("/insertarEstudiante")
	public String registroEstudiante(Estudiante estudiante) {

		return "vistaEstudiante";
	}
	
	@PostMapping("/estudiantesRegistrados")
	public String insertaCliente(Estudiante estudiante) {

		this.iEstudianteService.crear(estudiante);

		return "vistaInicioEstudiante";
	}
}
