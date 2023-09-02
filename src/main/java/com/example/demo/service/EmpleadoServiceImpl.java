package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEmpleadoRepository;
import com.example.demo.repository.modelo.Empleado;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	private IEmpleadoRepository empleadoRepository;


	// CRUD
	@Override
	public void ingresar(Empleado empleado) {
		this.empleadoRepository.ingresar(empleado);
	}

	@Override
	public Empleado buscarPorId(Integer id) {
		return this.buscarPorId(id);
	}

	@Override
	public Boolean autenticar(String user, String pass) {
		Empleado empleado = this.empleadoRepository.buscarUser(user);
		System.out.println("Encontro el usuario");
		if (empleado == null) {
			return false;
		} else {
			System.out.println(empleado.getContrasenia());
			System.out.println(pass);
			if (empleado.getContrasenia().equals(pass)) {
				System.out.println("si es la contraseña");
				return true;
			} else {
				System.out.println("no es la contraseña");
				return false;
			}
		}
	}

	public String siguienteVista(String user, String pass) {
		/*if (this.autenticar(user, pass)) {
			return "vInicioE";
		} else if (this.clienteService.autenticar(user, pass)) {
			return "vInicioC";
		} else {*/
			return "redirect:/inicio";
		}
	

}
