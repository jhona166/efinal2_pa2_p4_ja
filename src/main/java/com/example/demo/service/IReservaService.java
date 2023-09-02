package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.demo.repository.modelo.Reserva;

public interface IReservaService {

	public void guardar(Reserva reserva);

	public void actualizar(Reserva reserva);

	public Reserva buscar(Integer id);

	public void borrar(Integer id);
	
	//public BigDecimal calcularValorTotal(BigDecimal valorPorDia, LocalDateTime fechaInicio, LocalDateTime fechaFin);

	//public long calcularDias(LocalDateTime inicio, LocalDateTime fin);
}
