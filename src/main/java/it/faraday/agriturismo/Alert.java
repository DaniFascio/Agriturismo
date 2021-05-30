package it.faraday.agriturismo;

public class Alert {

	private String message;
	private String type;

	public Alert() {
	}

	public Alert(String message, String type) {
		this.message = message;
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public Alert setMessage(String message) {
		this.message = message;
		return this;
	}

	public String getType() {
		return type;
	}

	public Alert setType(String type) {
		this.type = type;
		return this;
	}

	public Alert success(String message) {
		this.message = message;
		type = "success";
		return this;
	}

	public Alert error(String message) {
		this.message = message;
		type = "danger";
		return this;
	}

	public Alert primary() {
		type = "primary";
		return this;
	}

	public String getRawHtml() {
		//noinspection StringBufferReplaceableByString
		return new StringBuilder().append("<div class='alert alert-")
				.append(type)
				.append(" alert-dismissible fade show' role='alert'>")
				.append("<span>")
				.append(message)
				.append("</span>")
				.append("<button type='button' class='close' data-dismiss='alert' aria-label='Close'>")
				.append("<span aria-hidden='true'>&times;</span>")
				.append("</button></div>")
				.toString();
	}

	@Override
	public String toString() {
		return "Alert{" + "message='" + message + '\'' + ", type='" + type + '\'' + '}';
	}

}
