package one.digitalinnovation.parking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PriceNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1192674073256227200L;

	public PriceNotFoundException(Long id) {
		super("Price not fund with Id : " + id);
	}

}
