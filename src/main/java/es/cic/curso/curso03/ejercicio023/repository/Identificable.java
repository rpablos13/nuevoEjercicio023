package es.cic.curso.curso03.ejercicio023.repository;

import java.io.Serializable;

public interface Identificable<K> extends Serializable {

	K getId();

	void setId(K id);
}