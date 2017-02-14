package es.cic.curso.curso03.ejercicio023.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import es.cic.curso.curso03.ejercicio023.Peliculas;

@Service
public interface CineService {
	
	Long aniadirPelicula(String titulo, String director, int notaImdb, int duracion, String nacionalidad, Long id);
	void modificarPelicula(String titulo, String director, int notaImdb, int duracion, String nacionalidad, Long id);
	void eliminarPelicula(Long id);
	Peliculas listaPeliculas(Long id);
	List<Peliculas> obtenerlistaPeliculas();
}