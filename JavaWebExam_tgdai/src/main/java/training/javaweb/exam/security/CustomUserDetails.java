package training.javaweb.exam.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import training.javaweb.exam.entity.User;

public class CustomUserDetails implements UserDetails {
	private final User user;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String roleName = user.getRole();
		if (roleName != null && !roleName.startsWith("ROLE_")) {
			roleName = "ROLE_" + roleName;
		}
		return List.of(new SimpleGrantedAuthority(roleName));
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return Boolean.TRUE.equals(user.getEnable());
	}

	public CustomUserDetails(User user) {
		super();
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public Long getOwnerId() {
		return user.getOwnerId();
	}
}