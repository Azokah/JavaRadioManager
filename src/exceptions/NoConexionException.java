package exceptions;

public class NoConexionException extends Exception {

	public NoConexionException() {
		super();
	}

	public NoConexionException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoConexionException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoConexionException(String message) {
		super(message);
	}

	public NoConexionException(Throwable cause) {
		super(cause);
	}

}
