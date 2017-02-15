package com.co.service;

import com.co.entidades.Countries;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.springframework.stereotype.Service;

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

    public List<Countries> getCountries() {
        Query q = m.createNamedQuery("GET_COUNTRIES");
        List<Countries> countries = q.getResultList();
        return countries;
    }

    public void deleteCountryxId(Countries country) {

        Query q = m.createNamedQuery("DELETE_COUNTRIES_ID").setParameter(
                "id", BigDecimal.valueOf(Long.valueOf(country.getCountryId().toString())));
        m.flush();
        m.getTransaction().commit();

    }
    	public void insert(Countries countrie) {
		m.getTransaction().begin();
		m.persist(countrie);
		m.flush();
		m.getTransaction().commit();
	}
    
}
