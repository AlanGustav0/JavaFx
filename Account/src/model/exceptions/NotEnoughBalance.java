package model.exceptions;

public class NotEnoughBalance extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public NotEnoughBalance(String message) {
		super(message);
	}

}
