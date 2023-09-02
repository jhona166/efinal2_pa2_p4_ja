package com.example.demo.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IReservaRepository;
import com.example.demo.repository.modelo.Reserva;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class ReservaServiceImpl implements IReservaService {

	@Autowired
	private IReservaRepository iReservaRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void guardar(Reserva reserva) {
		this.iReservaRepository.insertar(reserva);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizar(Reserva reserva) {
		this.iReservaRepository.actualizar(reserva);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Reserva buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iReservaRepository.seleccionar(id);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void borrar(Integer id) {
		this.iReservaRepository.eliminar(id);
	}

//	@Override
//	public BigDecimal calcularValorTotal(BigDecimal valorPorDia, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
//		// TODO Auto-generated method stub
//		long dias= this.calcularDias(fechaInicio, fechaFin);
//
//		BigDecimal subtotal = valorPorDia.multiply(new BigDecimal(dias)).setScale(2, RoundingMode.UP);
//
//		BigDecimal iva = subtotal.multiply(new BigDecimal(0.12)).setScale(2, RoundingMode.UP);
//
//		BigDecimal total = subtotal.add(iva).setScale(2, RoundingMode.UP);
//
//		return total;
//		
//	}
	
//	@Override
//	public long calcularDias(LocalDateTime inicio, LocalDateTime fin) {
//	    //Duracion duration = Duration.between(inicio, fin);
//	    return null;
//
//	}

}
