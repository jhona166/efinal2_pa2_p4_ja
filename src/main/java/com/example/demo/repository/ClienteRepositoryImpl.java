package com.example.demo.repository;

import org.springframework.stereotype.Service;

import com.example.demo.repository.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
@Service 
@Transactional
public class ClienteRepositoryImpl implements IClienteRepository{
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	@Transactional(value=TxType.MANDATORY)
	public void insertar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cliente);
	}

	@Override
	@Transactional(value=TxType.MANDATORY)
	public void actualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cliente);
	}

	@Override
	@Transactional(value=TxType.MANDATORY)
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Cliente clie = this.buscarPorId(id);
		this.entityManager.remove(clie);
	}
                
	@Override
	@Transactional(value=TxType.NOT_SUPPORTED)
	public Cliente buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Cliente> myQuery = this.entityManager.createQuery("SELECT c FROM Cliente c WHERE c.cedula=:datoCedula",Cliente.class); 
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}


	@Override
	@Transactional(value=TxType.NOT_SUPPORTED)
	public Cliente buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Cliente.class, id);
	}

}
