package es.cic.curso.curso03.ejercicio023.exception;

public class MyException extends RuntimeException {

	
	private static final long serialVersionUID = -7494874136176670384L;

	public MyException(String message){
		super(message);
	}
}

