package diachuk.project.marketplace.entity.security;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsImpl implements UserDetails {
	private String username;
	private String password;
	private Set<GrantedAuthority> authorities;

	public static UserDetailsImpl fromUser(User user) {
		return UserDetailsImpl.builder()
							  .username(user.getUsername())
							  .password(user.getPassword())
							  .authorities(user.getRoles()
											   .stream()
											   .map(UserDetailsImpl::mapRoleToAuthority)
											   .collect(Collectors.toSet()))
							  .build();
	}

	private static GrantedAuthority mapRoleToAuthority(Role role) {
		return new SimpleGrantedAuthority(role.getName().name());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
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
		return true;
	}
}
