package tn.spring.bookStore.exception;

/**
 * @author Spingler-PC
 *
 */
public class ServiceValidationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3270664234186048771L;

	private Integer status;
	private String message;

	public ServiceValidationException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceValidationException(Integer status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
