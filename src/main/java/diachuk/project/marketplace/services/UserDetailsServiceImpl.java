package diachuk.project.marketplace.services;

import diachuk.project.marketplace.dto.UserRequest;
import diachuk.project.marketplace.entity.security.Role;
import diachuk.project.marketplace.entity.security.User;
import diachuk.project.marketplace.entity.security.UserDetailsImpl;
import diachuk.project.marketplace.repos.UserRepo;
import java.util.Arrays;
import java.util.HashSet;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
	private final UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return UserDetailsImpl.fromUser(userRepo.findByUsername(username).orElseThrow());
	}


}
