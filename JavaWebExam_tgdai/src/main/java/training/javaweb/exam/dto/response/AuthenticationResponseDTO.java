package training.javaweb.exam.dto.response;

public class AuthenticationResponseDTO {
	private String role;
	private boolean authenticated;

	public AuthenticationResponseDTO(boolean authenticated) {
		super();
		this.authenticated = authenticated;
	}

	public AuthenticationResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

}
