package training.javaweb.exam.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pet {
	private Long id;
	private String name;
	private String type;
	private String breed;
	private Integer age;
	private BigDecimal weight;
	private String imageUrl;
	private Long ownerId;
	private LocalDateTime createdAt;

	public Pet(Long id, String name, String type, String breed, Integer age, BigDecimal weight, String imageUrl,
			Long ownerId, LocalDateTime createdAt) {
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
	}

	public Pet() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
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

}
