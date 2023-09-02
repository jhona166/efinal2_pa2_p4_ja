package com.example.demo.repository.modelo.DTO;

import java.time.LocalDate;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

public class MatriculaDTO {
	private String cedulaEstudiante;
	private String codigoMateria;
	private LocalDate fechaMatricula;
	private Integer id;
	public MatriculaDTO() {
	}

	public MatriculaDTO(String cedulaEstudiante, String codigoMateria, LocalDate fechaMatricula, Integer id) {
		super();
		this.cedulaEstudiante = cedulaEstudiante;
		this.codigoMateria = codigoMateria;
		this.fechaMatricula = fechaMatricula;
		this.id = id;
	}

	public String getCedulaEstudiante() {
		return cedulaEstudiante;
	}

	public void setCedulaEstudiante(String cedulaEstudiante) {
		this.cedulaEstudiante = cedulaEstudiante;
	}

	public String getCodigoMateria() {
		return codigoMateria;
	}

	public void setCodigoMateria(String codigoMateria) {
		this.codigoMateria = codigoMateria;
	}

	public LocalDate getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(LocalDate fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "MatriculaDTO [cedulaEstudiante=" + cedulaEstudiante + ", codigoMateria=" + codigoMateria
				+ ", fechaMatricula=" + fechaMatricula + ", id=" + id + "]";
	}




}