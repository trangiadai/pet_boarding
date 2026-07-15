package training.javaweb.exam.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

public class OwnerResponseDTO {
	@Schema(description = "The id of the owner", example = "12")
	private Long id;
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

	@Schema(description = "The information of the owner's pets")
	private List<PetResponseDTO> pets;

	public OwnerResponseDTO() {
		super();
	}

	public OwnerResponseDTO(Long id, String name, String phone, String email, String address, LocalDateTime createdAt,
			List<PetResponseDTO> pets) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.createdAt = createdAt;
		this.pets = pets;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<PetResponseDTO> getPets() {
		return pets;
	}

	public void setPets(List<PetResponseDTO> pets) {
		this.pets = pets;
	}

}
