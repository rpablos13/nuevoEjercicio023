package es.cic.curso.curso03.ejercicio023.servicio;

import java.util.List;



import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.cic.curso.curso03.ejercicio023.Peliculas;
import es.cic.curso.curso03.ejercicio023.exception.MyException;
import es.cic.curso.curso03.ejercicio023.repository.PeliculasRepository;



@Service
public class CineServiceImpl implements CineService {

	@Autowired
	private PeliculasRepository peliculasRepo;
	
	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public Long aniadirPelicula(String titulo, String director, int notaImdb, int duracion, String nacionalidad, Long id) {
		Peliculas pelicula = new Peliculas();
		pelicula.setId(id);
		pelicula.setDirector(director);
		pelicula.setDuracion(duracion);
		pelicula.setNacionalidad(nacionalidad);
		pelicula.setNotaImdb(notaImdb);
		pelicula.setTitulo(titulo);
		
		Peliculas aniadido = aniadirPeliculas(pelicula);
		
		return aniadido.getId();
	}

	private Peliculas aniadirPeliculas(Peliculas nuevaPelicula) {
		
		peliculasRepo.add(nuevaPelicula);
		entityManager.flush();
		
		return nuevaPelicula;
	}


	@Override
	public void modificarPelicula(String titulo, String director, int notaImdb, int duracion, String nacionalidad, Long id) {
		
		comprobarExistencia(id);
		
		Peliculas peliculasExistente = peliculasRepo.read(id);
		peliculasExistente.setDirector(director);
		peliculasExistente.setDuracion(duracion);
		peliculasExistente.setNacionalidad(nacionalidad);
		peliculasExistente.setNotaImdb(notaImdb);
		peliculasExistente.setTitulo(titulo);
		
		peliculasRepo.update(peliculasExistente);
		
	}

	@Override
	public void eliminarPelicula(Long id) {
		
		Peliculas peliculaBorrar = listaPeliculas(id);
		peliculasRepo.delete(peliculaBorrar);
		
	}

	@Override
	public Peliculas listaPeliculas(Long id) {
		return peliculasRepo.read(id);
	}

	@Override
	public List<Peliculas> obtenerlistaPeliculas() {
		return peliculasRepo.list();
	}
	
	private void comprobarExistencia(Long id) {
		if (peliculasRepo.read(id) == null) {
			throw new MyException("No existe la pelicula: " + id);
		}
	}
	
		
}