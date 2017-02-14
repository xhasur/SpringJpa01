package com.co.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.springframework.stereotype.Service;
import com.co.entidades.Persons;
import com.co.util.Constantes;

@Service
public class ServiceDba {

	private static final String PERSISTENCE_UNIT_NAME = "Modelo";
	EntityManager m = getConexion();

	private EntityManager getConexion() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		return em;
	}

	public void insert(Persons person) {
		m.getTransaction().begin();
		m.persist(person);
		m.flush();
		m.getTransaction().commit();
	}

	public void deleteAve(Persons person) {

		m.getTransaction().begin();
		person = m.merge(person);
		m.remove(person);
		m.flush();
		m.getTransaction().commit();
	}

	public List<Persons> getPersons() {
		Query q = m.createNamedQuery(Constantes.get_persons);
		List<Persons> persons = q.getResultList();
		return persons;
	}

	public void deletePersonxId(Persons person) {

		Query q = m.createNamedQuery(Constantes.delete_persons_id).setParameter(
				"id", BigDecimal.valueOf(Long.valueOf(person.getId().toString())));
		m.flush();
		m.getTransaction().commit();

	}

}
