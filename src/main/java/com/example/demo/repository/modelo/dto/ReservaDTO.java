package com.example.demo.repository.modelo.dto;

import java.math.BigDecimal;

import java.math.BigDecimal;

public class ReservaDTO {
	
	private String placa;

	private String cedula;

	private String fechaInicio;

	private String fechaFin;

	private String numeroTarjeta;
	
	private BigDecimal total;
	
	
	public ReservaDTO() {
		super();
	}


	public ReservaDTO(String placa, String cedula, String fechaInicio, String fechaFin, String numeroTarjeta,
			BigDecimal total) {
		super();
		this.placa = placa;
		this.cedula = cedula;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.numeroTarjeta = numeroTarjeta;
		this.total = total;
	}

	//Set and Get

	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public String getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public String getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}


	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}


	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}


	public BigDecimal getTotal() {
		return total;
	}


	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	

	
	
	
	
	
	
	
}
