package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;

public interface IMatriculaService {
	public void crear(Matricula matricula);
	public Matricula generarMatricula(String cedula, List<Materia>materias);
	
}
