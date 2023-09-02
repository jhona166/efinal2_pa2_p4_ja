package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IClienteRepository;
import com.example.demo.repository.modelo.Cliente;

import org.springframework.stereotype.Service;

@Service

public class ClienteServiceImpl implements IClienteService{
	@Autowired
	private IClienteRepository iClienteRepository;

	@Override
	public void crear(Cliente cliente) {
		// TODO Auto-generated method stub
		this.iClienteRepository.insertar(cliente);
	}

	@Override
	public void actualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.iClienteRepository.actualizar(cliente);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iClienteRepository.eliminar(id);
	}

	@Override
	public Cliente buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.iClienteRepository.buscarPorCedula(cedula);
	}

	@Override
	public Cliente buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.iClienteRepository.buscarPorId(id);
	}

}
