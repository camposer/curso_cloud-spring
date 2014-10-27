package cloudspring.personarest.to;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class RespuestaRest {
	private Status status;
	private Object data;
	private String error;
	
	public static enum Status {
		SUCCESS, ERROR;
	}

	public RespuestaRest() {
		// TODO Auto-generated constructor stub
	}
	
	public RespuestaRest(Object data) {
		this.status = Status.SUCCESS;
		this.data = data;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
