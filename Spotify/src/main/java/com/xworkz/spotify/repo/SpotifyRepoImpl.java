package com.xworkz.spotify.repo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.spotify.dto.SpotifyDto;

@Repository
public class SpotifyRepoImpl implements SpotifyRepo {

	@Autowired
	private EntityManagerFactory emf;

	@Override
	public boolean save(SpotifyDto dto) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(dto);
		em.getTransaction().commit();
		return true;
	}

}
