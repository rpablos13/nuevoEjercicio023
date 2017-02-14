package es.cic.curso.curso03.ejercicio023;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;

public class PeliculasForm extends FormLayout {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3949325445848506975L;

	@PropertyId("titulo")
	protected TextField titulo;
	
	@PropertyId("director")
	protected TextField director;
	
	@PropertyId("notaImdb")
	protected TextField notaImdb;
	
	@PropertyId("duracion")
	protected TextField duracion;
	
	@PropertyId("nacionalidad")
	protected TextField nacionalidad;
	
	private Button accion;
	private Button nuevo;
	private Button borrar;
	
	public PeliculasForm(MyUI padre) {
		
		titulo = new TextField("Titulo: ");
		director= new TextField("Director: ");
		notaImdb = new TextField("Nota IMDB: ");
		duracion= new TextField("Duracion: ");
		nacionalidad = new TextField("Nacionalidad: ");
		
		
		accion = new Button("Añadir");
		nuevo = new Button("Nuevo");
		borrar = new Button("Borrar");
		
		borrar.removeClickListener(e -> padre.cargaGrid());
		
		nuevo.addClickListener(e -> padre.cargaGrid());
		
		accion.addClickListener(e -> padre.cargaGrid());
		
		addComponents(titulo, director, notaImdb, duracion, nacionalidad, accion);
		

		setPeliculas(null);
	}

	public void setPeliculas(Peliculas peliculas) {
		this.setVisible(peliculas != null);
		if (peliculas != null) {
			BeanFieldGroup.bindFieldsUnbuffered(peliculas, this);
		} else {
			BeanFieldGroup.bindFieldsUnbuffered(new Peliculas(), this);
		}
	}
}