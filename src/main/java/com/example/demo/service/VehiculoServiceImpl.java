package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.IVehiculoRepository;
import com.example.demo.repository.modelo.Reserva;
import com.example.demo.repository.modelo.Vehiculo;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

	@Autowired
	private IVehiculoRepository vehiculoRepository;

	@Override
	public void guardar(Vehiculo vehiculo) {
		this.vehiculoRepository.insertar(vehiculo);
	}

	@Override
	public Vehiculo encontrar(Integer id) {
		return this.vehiculoRepository.buscar(id);
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		this.vehiculoRepository.actualizar(vehiculo);
	}

	@Override
	public void borrar(Integer id) {
		this.vehiculoRepository.eliminar(id);
	}


	@Override
	public Vehiculo buscarPlaca(String placa) {
		return this.vehiculoRepository.buscarPlaca(placa);
	}


	
	@Override
	public List<Vehiculo> vehiculosVIP(LocalDateTime fecha) {
		List<Vehiculo> vehiculos = this.vehiculoRepository.reporteVehiculo(fecha);
		List<Vehiculo> vehiculosVIP = vehiculos.stream()
				.sorted(Comparator.comparingDouble(
						a -> a.getReservas().stream().map(b -> b.getTotal().doubleValue()).reduce(0.0, Double::sum)))
				.collect(Collectors.toList());
		vehiculosVIP.parallelStream().forEach(a -> {
			a.setCilindraje(this.calcularSubtotal(a).toString());
			a.setValorDia(new BigDecimal(this.calcularTotal(a)));
		});
		Collections.reverse(vehiculosVIP);
		return vehiculosVIP;
	}

	public List<Vehiculo> buscarTodosDisponibles() {
		return this.vehiculoRepository.buscarTodosDisponibles();
	}

	@Override
	public Double calcularSubtotal(Vehiculo vehiculo) {
		List<Reserva> lista = vehiculo.getReservas();
		Double subTotal = lista.parallelStream().map(b -> b.getSubtotal().doubleValue()).reduce(0.0, Double::sum);
		return subTotal;
	}

	@Override
	public Double calcularTotal(Vehiculo vehiculo) {
		List<Reserva> lista = vehiculo.getReservas();
		Double total = lista.parallelStream().map(b -> b.getTotal().doubleValue()).reduce(0.0, Double::sum);
		return total;
	}
	
	@Override
	public void borrarDisponible(Integer id, Boolean D) {
		if (D) {
			borrar(id);
		} else {
			System.out.println("Vehículo no disponible, no es posible eliminar.");
		}
	}

	@Override
	@Transactional(value=TxType.REQUIRES_NEW)
	public List<Vehiculo> buscarVehiculosDisponibles(String marca, String modelo) {
		// TODO Auto-generated method stub
		return this.vehiculoRepository.buscar(marca, modelo);
	}

	@Override
	public List<Vehiculo> encontrarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
