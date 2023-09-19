package com.xworkz.taxii.repo;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.taxii.dto.TaxiiDto;

@Component
public class TaxiiRepoImpl implements TaxiiRepo {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Taxii");

	@Override
	public boolean saveTaxi(TaxiiDto dto) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(dto);
		transaction.commit();
		em.close();
		return true;
	}

	@Override
	public List<TaxiiDto> readAll() {
		EntityManager em = emf.createEntityManager();
		TypedQuery<TaxiiDto> quary = em.createNamedQuery("readAll", TaxiiDto.class);
		List<TaxiiDto> list = quary.getResultList();
		
	

		
//		   MyCompareter cm = new MyCompareter();
//		   
//		   Collections.sort(list,cm);
//		    System.out.println(list);


		return list;
	}

	@Override
	public boolean updatebyearning(int earning) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Query query = em.createNamedQuery("updatebyearning");
		query.setParameter("er", earning);
		query.executeUpdate();
		transaction.commit();
		em.close();
		return true;
	}

	@Override
	public boolean updateisAvailableById(int id, boolean isAvailable) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Query query = em.createNamedQuery("updateisAvailableById");
		query.setParameter("isA", isAvailable);
		query.setParameter("id", id);
		query.executeUpdate();
		transaction.commit();
		em.close();
		return true;
	}

	@Override
	public TaxiiDto findtaxinoBylocation(String location, int taxino) {
		EntityManager em = emf.createEntityManager();
		TypedQuery<TaxiiDto> quary = em.createNamedQuery("findtaxinoBylocation", TaxiiDto.class);
		quary.setParameter("tx", taxino);
		quary.setParameter("lc", location);
		TaxiiDto dto = quary.getSingleResult();
		return dto;
	}

	@Override
	public List<TaxiiDto> findByisAvailable(boolean b) {
		EntityManager em = emf.createEntityManager();
		TypedQuery<TaxiiDto> quary = em.createNamedQuery("findByisAvailable", TaxiiDto.class);
		quary.setParameter("isA", b);
		List<TaxiiDto> list = (List<TaxiiDto>) quary.getResultList();

		return list;
	}

	@Override

	public TaxiiDto bookTaxi() {
		List<TaxiiDto> ref = findByisAvailable(true);
		MyCompareter com = new MyCompareter();
		Collections.sort(ref,com);
		for(TaxiiDto list:ref) {
			System.out.println(list);
		}
		for(TaxiiDto list1:ref) {
			int eachTripEarning = 500;
		    int updateEarnings =list1.getEarning()+eachTripEarning;
		    updatebyearning(updateEarnings);
		    
		    
		    updateisAvailableById(list1.getId(), false);
		    return list1;
		    
			
		}
		return null;
		
	
		
	}

}
