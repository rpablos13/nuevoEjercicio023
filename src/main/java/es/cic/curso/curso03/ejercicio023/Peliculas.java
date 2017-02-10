package es.cic.curso.curso03.ejercicio023;

import com.vaadin.ui.TextField;

public class Peliculas {
	
	private String titulo;
	private String director;
	private int notaImdb;
	private int duracion;
	private String nacionalidad;

	
	public Peliculas() {
		super();
	}
	
	

	public Peliculas(String titulo, String director, int notaImdb, int duracion, String nacionalidad) {
		super();
		this.titulo = titulo;
		this.director = director;
		this.notaImdb = notaImdb;
		this.duracion = duracion;
		this.nacionalidad = nacionalidad;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getDirector() {
		return director;
	}



	public void setDirector(String director) {
		this.director = director;
	}



	public int getNotaImdb() {
		return notaImdb;
	}



	public void setNotaImdb(int notaImdb) {
		this.notaImdb = notaImdb;
	}



	public int getDuracion() {
		return duracion;
	}



	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}



	public String getNacionalidad() {
		return nacionalidad;
	}



	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	
	
}
