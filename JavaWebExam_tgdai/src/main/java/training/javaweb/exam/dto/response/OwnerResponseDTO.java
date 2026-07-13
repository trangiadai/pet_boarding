package training.javaweb.exam.dto.response;

import java.security.Timestamp;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

public class OwnerResponseDTO {
	@Schema(description = "The name of the owner", example = "Tran Van A")
	private String name;
	@Schema(description = "The phone number of the owner", example = "0123456789")
	private String phone;
	@Schema(description = "The email of the owner", example = "example@email.com")
	private String email;
	@Schema(description = "The address of the owner", example = "123 ABC, Q1, TP.HCM")
	private String address;
	@Schema(description = "The date of owner infomation when it is created", example = "2026-07-13T09:47:48")
	private LocalDateTime createdAt;

	public OwnerResponseDTO() {
		super();
	}

	public OwnerResponseDTO(String name, String phone, String email, String address, LocalDateTime createdAt) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.createdAt = createdAt;
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

}
