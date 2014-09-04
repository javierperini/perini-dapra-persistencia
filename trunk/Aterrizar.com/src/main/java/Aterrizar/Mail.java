package Aterrizar;

public class Mail {

	private String cuerpo;
	private String from;
	private CorreoElectronico email;

	public Mail(String cuerpo, CorreoElectronico email, String from) {
		this.cuerpo=cuerpo;
		this.email=email;
		this.from=from;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public String getFrom() {
		return from;
	}

	public CorreoElectronico getEmail() {
		return email;
	}

}
