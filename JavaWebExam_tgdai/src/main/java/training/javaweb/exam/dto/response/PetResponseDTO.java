package training.javaweb.exam.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import training.javaweb.exam.enums.BoardingStatus;
import training.javaweb.exam.enums.PetType;

public class PetResponseDTO {
	@Schema(description = "The id of the pet", example = "1")
	private Long id;
	@Schema(description = "The name of the pet", example = "Kiki")
	private String name;
	@Schema(description = "The type of pet", example = "CAT")
	private PetType type;
	@Schema(description = "The breed of pet", example = "Golden Retriever Cat")
	private String breed;
	@Schema(description = "The age of pet", example = "3")
	private Integer age;
	@Schema(description = "The weight of pet", example = "2.10")
	private BigDecimal weight;
	@Schema(description = "The image of pet", example = "https://placedog.net/200/200?id=1")
	private String imageUrl;
	@Schema(description = "The id of owner of the pet", example = "1")
	private Long ownerId;
	@Schema(description = "The formal entry date of batch into system logs", example = "2026-07-13T09:47:48")
	private LocalDateTime createdAt;
	@Schema(description = "The owner information of the pet")
	private OwnerResponseDTO owner;
	@Schema(description = "Current boarding status of the pet", example = "BOARDING")
	private BoardingStatus status;

	public PetResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PetResponseDTO(Long id, String name, PetType type, String breed, Integer age, BigDecimal weight,
			String imageUrl, Long ownerId, LocalDateTime createdAt, OwnerResponseDTO owner, BoardingStatus status) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.breed = breed;
		this.age = age;
		this.weight = weight;
		this.imageUrl = imageUrl;
		this.ownerId = ownerId;
		this.createdAt = createdAt;
		this.owner = owner;
		this.status = status;
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

	public PetType getType() {
		return type;
	}

	public void setType(PetType type) {
		this.type = type;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public OwnerResponseDTO getOwner() {
		return owner;
	}

	public void setOwner(OwnerResponseDTO owner) {
		this.owner = owner;
	}

	public BoardingStatus getStatus() {
		return status;
	}

	public void setStatus(BoardingStatus status) {
		this.status = status;
	}

}
