package com.example.demo.repository.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="materia")
public class Materia {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "materia_seq")
	@SequenceGenerator(name = "materia_seq", sequenceName = "materia_seq", allocationSize = 1)
	@Column(name="mate_id")
	private Integer id;
	@Column(name="mate_nombre")
	private String nombre;
	@Column(name="mate_codigo")
	private String codigo;
	@Column(name="mate_numCreditos")
	private String numCreditos;
	@Column(name="mate_cedProfesor")
	private String cedProfesor;
	
	//OK
	@OneToMany(mappedBy = "materia")
	private List<Matricula> matriculas;
	
	
	
	public List<Matricula> getMatriculas() {
		return matriculas;
	}
	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
	@Override
	public String toString() {
		return "Materia [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", numCreditos=" + numCreditos
				+ ", cedProfesor=" + cedProfesor + "]";
	}
	//Set and Get
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNumCreditos() {
		return numCreditos;
	}
	public void setNumCreditos(String numCreditos) {
		this.numCreditos = numCreditos;
	}
	public String getCedProfesor() {
		return cedProfesor;
	}
	public void setCedProfesor(String cedProfesor) {
		this.cedProfesor = cedProfesor;
	}
	
	
	
	
	
}
