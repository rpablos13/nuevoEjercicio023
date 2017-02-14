package es.cic.curso.curso03.ejercicio023.repository;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import es.cic.curso.curso03.ejercicio023.repository.AbstractRepositoryImpl;
import es.cic.curso.curso03.ejercicio023.repository.PeliculasRepository;
import es.cic.curso.curso03.ejercicio023.Peliculas;

@Repository
@Transactional
public class PeliculasRepositoryImpl extends AbstractRepositoryImpl<Long, Peliculas> implements PeliculasRepository {

	
	@Override
	public Class<Peliculas> getClassDeT() {
		return Peliculas.class;
	}

	@Override
	public String getNombreTabla() {
		return "CINE";
	}

}
