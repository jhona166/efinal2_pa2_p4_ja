package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.repository.modelo.dto.VehiculoDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;


@Repository
@Transactional
public class VehiculoRepositoryImpl implements IVehiculoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Vehiculo vehiculo) {
		this.entityManager.persist(vehiculo);
	}

	@Override
	public Vehiculo buscar(Integer id) {
		return this.entityManager.find(Vehiculo.class, id);
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		this.entityManager.merge(vehiculo);
	}

	@Override
	public void eliminar(Integer id) {
		Vehiculo vehi = this.buscar(id);
		this.entityManager.remove(vehi);
	}


	// actualizar estado del vehiculo por placa
	@Override
	public Integer actualizarEstado(String placa) {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createNativeQuery(
				"UPDATE vehiculo SET vehi_estado = 'ND' WHERE vehi_placa = :datoPlaca", Vehiculo.class);
		query.setParameter("datoPlaca", placa);
		return query.executeUpdate();
	}

	// Obtener vehiculoDTO por placa
	@Override
	public VehiculoDTO buscarPorPlaca(String placa) {

		TypedQuery<VehiculoDTO> typedQuery = this.entityManager.createQuery(
				"SELECT new rent.car.modelo.dto.VehiculoDTO(e.placa, e.modelo,"
						+ "e.marca, e.anio, e.estado, e.valor) from Vehiculo e WHERE e.placa = :datoPlaca",
				VehiculoDTO.class);
		typedQuery.setParameter("datoPlaca", placa);
		return typedQuery.getSingleResult();
	}

	//buscar por placa
	public Vehiculo buscarPlaca(String placa) {
		TypedQuery<Vehiculo> query = this.entityManager
				.createQuery("SELECT e from Vehiculo e WHERE e.placa = :datoPlaca", Vehiculo.class);
		query.setParameter("datoPlaca", placa);
		return query.getSingleResult();

	}



	// Vehiculos VIP
	public List<Vehiculo> reporteVehiculo(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		TypedQuery<Vehiculo> query = this.entityManager
				.createQuery("SELECT v FROM Vehiculo v JOIN v.reserva r JOIN r.cobro co"
						+ " WHERE MONTH(co.fecha) = :datoMes AND YEAR(co.fecha)= :datoAño", Vehiculo.class);
		query.setParameter("datoMes", fecha.getMonthValue());
		query.setParameter("datoAño", fecha.getYear());
		return query.getResultList();

	}

	@Override
	public List<Vehiculo> buscarTodosDisponibles() {
		Query query = this.entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.estado=:datoDisp ");
		query.setParameter("datoDisp", "D");
		return query.getResultList();
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public List<Vehiculo> buscar(String marca, String modelo) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.marca=:datoMarca AND v.modelo=:datoModelo", Vehiculo.class);
		myQuery.setParameter("datoMarca",marca);
		myQuery.setParameter("datoModelo", modelo);
		return myQuery.getResultList();
	}

}
