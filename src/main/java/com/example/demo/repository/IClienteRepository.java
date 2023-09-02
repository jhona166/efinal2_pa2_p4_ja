package com.example.demo.repository;

import com.example.demo.repository.modelo.Cliente;

import com.example.demo.repository.modelo.Cliente;

public interface IClienteRepository {
	public void insertar(Cliente cliente);	
	public void actualizar(Cliente cliente);
	public void eliminar(Integer id);
	public Cliente buscarPorCedula(String cedula);
	public Cliente buscarPorId(Integer id);

	
	
	
}
