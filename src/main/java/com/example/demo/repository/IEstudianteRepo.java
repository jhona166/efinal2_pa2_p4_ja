package com.example.demo.repository;

import com.example.demo.repository.modelo.Estudiante;

public interface IEstudianteRepo {
		public void insertar(Estudiante estudiante);
		public Estudiante buscar(String cedula);
		
		
}