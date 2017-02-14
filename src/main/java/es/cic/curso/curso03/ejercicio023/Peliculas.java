package es.cic.curso.curso03.ejercicio023;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import es.cic.curso.curso03.ejercicio023.repository.Identificable;

@Entity
@Table(name="CINE")
public class Peliculas implements Identificable<Long> {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4248155118069914878L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	
	@Column(name="titulo")
	private String titulo;
	
	
	@Column(name="director")
	private String director;
	
	@Column(name="notaImdb")
	private int notaImdb;
	
	@Column(name="duracion")
	private int duracion;
	
	@Column(name="nacionalidad")
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



	@Override
	public Long getId() {
		return id;
	}



	@Override
	public void setId(Long id) {
		this.id = id;
		
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Peliculas other = (Peliculas) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Peliculas [id=" + id + ", titulo=" + titulo + ", director=" + director + ", notaImdb=" + notaImdb
				+ ", duracion=" + duracion + ", nacionalidad=" + nacionalidad + "]";
	}

	
	
}
