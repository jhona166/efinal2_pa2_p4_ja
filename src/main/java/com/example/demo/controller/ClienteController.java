package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.repository.modelo.dto.ReservaDTO;
import com.example.demo.service.IReservaService;
import com.example.demo.service.IVehiculoService;


@Controller
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
	private IVehiculoService iVehiculoService;
	@Autowired
	private IReservaService iReservaService;
	//Funcionalidad 1a
	//http://localhost:8080/rentaCar/clientes/vehiculosDisponibles
	@GetMapping("/vehiculosDisponibles")
	public String vehiculosDisponible(Vehiculo vehiculo, Model modelo) {
		List<Vehiculo> lista = this.iVehiculoService.buscarVehiculosDisponibles(vehiculo.getMarca(),vehiculo.getModelo());
		modelo.addAttribute("lista",lista);
		return "vistaVehiculosDisponibles";
	}
	
	//http://localhost:8080/rentaCar/clientes/buscar
	@GetMapping("/buscar")
	public String buscar(Vehiculo vehiculo) {
		return "vistaVehiculoBuscar";
	}
	
	@GetMapping("/inicio")
	public String mostrarClientes() {
		return "vistaPrincipalClientes";
	}
	
	@GetMapping("/regresar")
	public String regresar() {
		return "redirect:/clientes/inicio";
	}

	//Funcionalidad 1b
	//http://localhost:8080/rentaCar/clientes/reservar
	@GetMapping("/reservar")
	public String reservar(ReservaDTO reservaDTO) {
		return "vistaReserva";
	}
	
	// Funcionalidad 1b
//	@GetMapping("/reservarVehiculo")
//	public String reservarVehiculo(ReservaDTO reservaDTO, Model modelo) {
//
//		Vehiculo vehiculo = this.iVehiculoService.buscarPlaca(reservaDTO.getPlaca());
//		modelo.addAttribute("vehiculo", vehiculo);
//		modelo.addAttribute("total",this.iReservaService.calcularValorTotal(vehiculo.getValorDia(),
//						LocalDateTime.parse(reservaDTO.getFechaInicio()),
//						LocalDateTime.parse(reservaDTO.getFechaFin())));
//		modelo.addAttribute("reservaSencillo1", reservaDTO);
//		return "vistaReservaVehiculo";
//	}

	
	
}
