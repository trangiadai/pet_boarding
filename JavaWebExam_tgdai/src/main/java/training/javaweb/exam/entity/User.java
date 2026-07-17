package training.javaweb.exam.entity;

import java.time.LocalDateTime;

public class User {
	private Long id;
	private String username;
	private String password;
	private String role;
	private Long ownerId;
	private Boolean enable;
	private LocalDateTime createdAt;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long id, String username, String password, String role, Long ownerId, Boolean enable,
			LocalDateTime createdAt) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.ownerId = ownerId;
		this.enable = enable;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
