package com.example.demo.repository;

import com.example.demo.repository.modelo.Materia;

public interface IMateriaRepo {
	public void insertar(Materia materia);
	public Materia buscar(String codigo);
}
