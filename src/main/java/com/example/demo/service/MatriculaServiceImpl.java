package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepo;
import com.example.demo.repository.IMateriaRepo;
import com.example.demo.repository.IMatriculaRepo;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;

@Service
public class MatriculaServiceImpl implements IMatriculaService{

	@Autowired
	private IMatriculaRepo iMatriculaRepo;
	@Autowired
	private IEstudianteRepo iEstudianteRepo; 
	@Autowired
	private IMateriaRepo iMateriaRepo;
	
	@Override
	public void crear(Matricula matricula) {
		// TODO Auto-generated method stub
		this.iMatriculaRepo.insertar(matricula);
	}

	@Override
	public Matricula generarMatricula(String cedula, List<Materia> materias) {
		// TODO Auto-generated method stub
		Estudiante estu = this.iEstudianteRepo.buscar(cedula);
		Materia materia = this.iMateriaRepo.buscar(materias.get(0).getCodigo());
		Matricula matricula = new Matricula();
		
		this.iMatriculaRepo.insertar(matricula);
		return null;
	}

}
