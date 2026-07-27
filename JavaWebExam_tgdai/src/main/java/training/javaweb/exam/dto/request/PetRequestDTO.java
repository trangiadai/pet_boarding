package training.javaweb.exam.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import training.javaweb.exam.enums.PetType;

public class PetRequestDTO {
	@NotBlank(message = "Pet's name can not be empty or just a space/tab")
	@Size(max = 100, message = "The maximun characters for pet's name is 100")
	@Schema(description = "The name of the pet", example = "Kiki")
	private String name;

	@NotNull(message = "Pet's type can not be empty or invalid value")
	@Schema(description = "The type of pet", example = "CAT")
	private PetType type;

	@Size(max = 100, message = "The maximun characters for pet's breed is 100")
	@Schema(description = "The breed of pet", example = "Golden Retriever Cat")
	private String breed;

	@NotNull(message = "Pet's age can not be empty")
	@PositiveOrZero(message = "Pet's age must be >= 0")
	@Max(value = 500, message = "the maximun age of pet that the store can accept is 500")
	@Schema(description = "The age of pet", example = "3")
	private Integer age;

	@NotNull(message = "Pet's weight can not be empty or invalid value")
	@DecimalMin(value = "0.01", message = "The minimun weight of pet that the store can accept is 0,01")
	@DecimalMax(value = "999.99", message = "The maximun weight of pet that the store can accept is 999,99")
	@Schema(description = "The weight of pet", example = "2.10")
	private BigDecimal weight;

	@Size(max = 500, message = "The maximun characters for pet's image URL is 500")
	@Schema(description = "The image of pet", example = "https://placedog.net/200/200?id=1")
	private String imageUrl;

	@NotNull(message = "Owner's id can not be empty or invalid value")
	@Positive(message = "Owner's id must be > 0")
	@Schema(description = "The id of owner of the pet", example = "1")
	private Long ownerId;

	public PetRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PetRequestDTO(String name, PetType type, String breed, Integer age, BigDecimal weight, String imageUrl,
			Long ownerId, LocalDateTime createdAt) {
		super();
		this.name = name;
		this.type = type;
		this.breed = breed;
		this.age = age;
		this.weight = weight;
		this.imageUrl = imageUrl;
		this.ownerId = ownerId;
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

}