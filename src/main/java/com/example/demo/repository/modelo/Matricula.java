package com.example.demo.repository.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="matricula")
public class Matricula {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "matricula_seq")
	@SequenceGenerator(name = "matricula_seq", sequenceName = "matricula_seq", allocationSize = 1)
	@Column(name="matr_id")
	private Integer id;
	@Column(name="matr_estCedula")
	private String estCedula;
	@Column(name="matr_matCodigo")
	private String matCodigo;
	@Column(name="matr_fecha")
	private LocalDateTime fecha;
	@Column(name="matr_nomH")
	private String nomH;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="matr_id_alumno")
	private Estudiante estudiante;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="matr_id_materia")
	private Materia materia;
	
	
	
	
	@Override
	public String toString() {
		return "Matricula [id=" + id + ", estCedula=" + estCedula + ", matCodigo=" + matCodigo + ", fecha=" + fecha
				+ ", nomH=" + nomH + "]";
	}
	//Set and Get
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEstCedula() {
		return estCedula;
	}
	public void setEstCedula(String estCedula) {
		this.estCedula = estCedula;
	}
	public String getMatCodigo() {
		return matCodigo;
	}
	public void setMatCodigo(String matCodigo) {
		this.matCodigo = matCodigo;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public String getNomH() {
		return nomH;
	}
	public void setNomH(String nomH) {
		this.nomH = nomH;
	}
	
	
	
	
}
