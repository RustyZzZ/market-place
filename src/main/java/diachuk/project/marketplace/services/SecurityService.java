package diachuk.project.marketplace.services;

import diachuk.project.marketplace.dto.UserRequest;
import diachuk.project.marketplace.entity.security.Role;
import diachuk.project.marketplace.entity.security.User;
import diachuk.project.marketplace.repos.RoleRepo;
import diachuk.project.marketplace.repos.UserRepo;
import java.util.HashSet;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityService {
	private final UserRepo userRepo;
	private final RoleRepo roleRepo;
	private final PasswordEncoder passwordEncoder;

	public User createUser(UserRequest userRequest, String role) {
		var roles = new HashSet<Role>();
		var build = roleRepo.findByName(role);
		roles.add(build.orElseThrow());
		var user = User.builder()
					   .username(userRequest.getUsername())
					   .password(passwordEncoder.encode(userRequest.getPassword()))
					   .roles(roles)
					   .build();
		return userRepo.save(user);
	}

}
