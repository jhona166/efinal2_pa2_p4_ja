package com.example.demo.service;

import com.example.demo.repository.modelo.Empleado;

public interface IEmpleadoService {

	// CRUD
	public void ingresar(Empleado empleado);

	public Empleado buscarPorId(Integer id);
	
	// VERIFICAR USUARIO
	public Boolean autenticar(String user, String pass);
	
	//pasar siguiente vista 
	public String siguienteVista(String user, String pass);

}
