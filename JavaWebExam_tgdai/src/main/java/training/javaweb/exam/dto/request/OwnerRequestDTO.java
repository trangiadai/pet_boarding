package training.javaweb.exam.dto.request;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class OwnerRequestDTO {
	@NotBlank(message = "Owner's name can not be empty or just a space/tab")
	@Size(max = 100, message = "The maximun characters for owner's name is 100")
	@Schema(description = "The name of the owner", example = "Tran Van A")
	private String name;

	@NotBlank(message = "Owner's phone can not be empty or just a space/tab")
	@Size(min = 10, max = 20, message = "The minimun number for owner's phone is 10, and the maximun number for owner's phone is 20")
	@Pattern(regexp = "^[0-9]+$", message = "Phone number must contain only numbers")
	@Schema(description = "The phone number of the owner", example = "0123456789")
	private String phone;

	@Size(max = 100, message = "The maximun number characters for owner's email is 100")
	@Email(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Owner's email must be valid format example@email.com")
	@Schema(description = "The email of the owner", example = "example@email.com")
	private String email;

	@Size(max = 255, message = "The maximun number of characters for owner's address is 255")
	@Schema(description = "The address of the owner", example = "123 ABC, Q4, TP.HCM")
	private String address;

	@NotNull(message = "Owner's createdAt can not be empty")
	@PastOrPresent(message = "Input time is invalid value, it must be before current time")
	@Schema(description = "The date of owner infomation when it is created", example = "2026-07-13T09:47:48")
	private LocalDateTime createdAt;

	@Schema(description = "The account information of owner")
	private UserRequestDTO userRequest;

	public OwnerRequestDTO() {
		super();
	}

	public OwnerRequestDTO(String name, String phone, String email, String address, LocalDateTime createdAt,
			UserRequestDTO userRequest) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.createdAt = createdAt;
		this.userRequest = userRequest;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public UserRequestDTO getUserRequest() {
		return userRequest;
	}

	public void setUserRequest(UserRequestDTO userRequest) {
		this.userRequest = userRequest;
	}

}
