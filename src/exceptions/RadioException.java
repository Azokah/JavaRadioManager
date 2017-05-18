package exceptions;

public class RadioException extends Exception {

	public RadioException() {
	}

	public RadioException(String message) {
		super(message);
	}

	public RadioException(Throwable cause) {
		super(cause);
	}

	public RadioException(String message, Throwable cause) {
		super(message, cause);
	}

	public RadioException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
