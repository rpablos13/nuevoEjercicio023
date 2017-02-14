package es.cic.curso.curso03.ejercicio023.repository;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import es.cic.curso.curso03.ejercicio023.Peliculas;
import es.cic.curso.curso03.ejercicio023.servicio.CineService;

	@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration(
			locations={
					"classpath:es/cic/curso/curso03/ejercicio023/applicationContext.xml"
					})
	@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
		TransactionalTestExecutionListener.class})
	@Transactional
	public class PeliculasServiceTest {

		@Autowired
		private CineService sut;
		
		@PersistenceContext
		private EntityManager em;
		
		@Before
		public void setUp() throws Exception {
			
			
		}
		
		@Test
		@Ignore

		public void testAniadirPelicula() {
			
			Long nuevaPeli = sut.aniadirPelicula("Multiple", "No tengo ni idea", 2, 10, "EEUU", (long)1);			

			assertNotNull(nuevaPeli);
		}
		
		@Test
		@Ignore

		 public void testEliminarPelicula() {
			
			Long eliminarPeli = sut.aniadirPelicula("Blabal", "nlanalDirector", 2, 4, "blablaNacionalidad", (long)2);
			
			sut.eliminarPelicula(eliminarPeli);
			
			List<Peliculas> listaPeliculas = sut.obtenerlistaPeliculas();
			
			assertTrue(listaPeliculas.size() == 0);
			
			
		}
		
		@Test

		public void testListarPeliculas() {
			
			List<Peliculas> listaPeliculas = sut.obtenerlistaPeliculas();
			for(Peliculas peliculas : listaPeliculas){
			assertNotNull(peliculas.getId());
			
			
			}
		}

	}