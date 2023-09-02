package com.example.demo.repository;

import com.example.demo.repository.modelo.Reserva;

public interface IReservaRepository {
	
	public void insertar(Reserva reserva);
	
	public void actualizar(Reserva reserva);
	
	public Reserva seleccionar(Integer id);
	
	public void eliminar(Integer id);

}
