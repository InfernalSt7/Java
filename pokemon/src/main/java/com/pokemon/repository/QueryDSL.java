/*package com.pokemon.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQuery;

import trabajoCiclistas.entity.Llevar;
import trabajoCiclistas.entity.QCiclista;
import trabajoCiclistas.entity.QLlevar;

@Repository("queryDSL")
public class QueryDSL {
	
	private QCiclista qciclista=QCiclista.ciclista;
	private QLlevar qllevar=QLlevar.llevar;
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Llevar> listaCarrera(int id) {
		JPAQuery<Llevar> jpa = new JPAQuery<Llevar>(em);	
		
		List<Llevar> lista=jpa.from(qllevar).leftJoin(qciclista).on(qllevar.dorsal.id.eq(qciclista.id)).where(qllevar.dorsal.id.eq(id)).fetch();
	
		
		return lista;
	}
	
}*/
