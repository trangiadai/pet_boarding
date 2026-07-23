package training.javaweb.exam.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public class UserResponseDTO {
	@Schema(description = "The username of the user account", example = "0123456789")
	private String username;
	@Schema(description = "The status of user account", example = "true")
	private Boolean enable;

	public UserResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserResponseDTO(String username, String password, Boolean enable) {
		super();
		this.username = username;
		this.enable = enable;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

}
