package es.cic.curso.curso03.ejercicio023;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {
    
	private Grid maestro;
	private PeliculasForm detalle;
	
	private List<Peliculas> listaPeliculas;
	
	@Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        
        listaPeliculas = new ArrayList<>();
        listaPeliculas.add(new Peliculas("Into the wild", "Sean Penn", 10, 2, "Amerrica"));
        listaPeliculas.add(new Peliculas("127 horas", "Noi tengo ni idea", 10, 2, "Amerrica"));
        
        maestro = new Grid();
        maestro.setColumns("titulo", "director", "notaImdb", "duracion", "nacionalidad");
        
        cargaGrid();
        
        maestro.addSelectionListener(e -> 
        	{
        		Peliculas p = null;
        		if (!e.getSelected().isEmpty() ) {
	        		p = (Peliculas) e.getSelected().iterator().next();
        		} 
        		detalle.setPeliculas(p);
        	});
        
        detalle = new PeliculasForm(this);
        
        
        layout.addComponents(maestro, detalle);
        layout.setMargin(true);
        layout.setSpacing(true);
       
        
        
        setContent(layout);
    }

	public void cargaGrid() {
		maestro.setContainerDataSource(
        		new BeanItemContainer<>(Peliculas.class, listaPeliculas)
        );
	}

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
