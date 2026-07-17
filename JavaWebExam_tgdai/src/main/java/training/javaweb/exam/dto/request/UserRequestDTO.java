package training.javaweb.exam.dto.request;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class UserRequestDTO {
	@NotBlank(message = "User's password can't not be empty or just a space/tab")
	@Size(max = 255, message = "The maximun characters for user's password is 255")
	@Schema(description = "The password of the user account", example = "letmein")
	private String password;
	
	@NotNull(message = "Owner's id can't not be empty or invalid value")
	@Positive(message = "Owner's id must be > 0")
	@Schema(description = "The id of owner of the user account", example = "12")
	private Long ownerId;
	
	@NotNull(message = "User's active status can't not be empty")
	@Schema(description = "The status of user account", example = "true")
	private Boolean enable;
	
	@NotNull(message = "User's createdAt can't not be empty")
	@PastOrPresent(message = "Input time is invalid value, it must be before current time")
	@Schema(description = "The formal entry date of batch into system logs", example = "2026-07-13T09:47:48")
	private LocalDateTime createdAt;

	public UserRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRequestDTO(String password, Long ownerId, Boolean enable, LocalDateTime createdAt) {
		super();
		this.password = password;
		this.ownerId = ownerId;
		this.enable = enable;
		this.createdAt = createdAt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

}
