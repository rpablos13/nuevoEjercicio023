package es.cic.curso.curso03.ejercicio023;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;

public class PeliculasForm extends FormLayout {
	@PropertyId("firstName")
	protected TextField firstName;
	
	@PropertyId("lastName")
	protected TextField lastName;
	
	private Button accion;
	
	private Peliculas peliculas;
	
	private MyUI padre;
	
	public PeliculasForm(MyUI padre) {
		this.padre = padre;
		
		firstName = new TextField("Nombre: ");
		lastName= new TextField("Apellido: ");
		
		accion = new Button("Actualizar");
		accion.addClickListener(e -> padre.cargaGrid());
		
		addComponents(firstName, lastName, accion);
		

		setPersona(null);
	}

	public void setPersona(Peliculas peliculas) {
		this.setVisible(peliculas != null);
		this.peliculas = peliculas;

		if (peliculas != null) {
			BeanFieldGroup.bindFieldsUnbuffered(peliculas, this);
		} else {
			BeanFieldGroup.bindFieldsUnbuffered(new Peliculas(), this);
		}
	}
}
