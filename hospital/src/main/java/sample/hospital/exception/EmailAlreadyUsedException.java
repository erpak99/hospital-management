package sample.hospital.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EmailAlreadyUsedException extends IllegalArgumentException {

	
	private static final long serialVersionUID = 1L;
	
	public EmailAlreadyUsedException() {
		super("The email address already exists in the system. "
              + "Please try to sign up with another mail address");
	}

}
