package diachuk.project.marketplace.controller;

import diachuk.project.marketplace.dto.UserRequest;
import diachuk.project.marketplace.entity.security.Role;
import diachuk.project.marketplace.entity.security.User;
import diachuk.project.marketplace.services.SecurityService;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/v1/security")
public class SecurityController {
	private final SecurityService service;
	public void createUser(){
		var adminRequest = new UserRequest();
		adminRequest.setUsername("admin");
		adminRequest.setPassword("admin");
		service.createUser(adminRequest, Role.ERole.ROLE_ADMIN);
	}


	@PostMapping("/createUser")
	@PreAuthorize("isAnonymous()")
	public ResponseEntity<User> registerUser(UserRequest userDto){
		return  ResponseEntity.ok(service.createUser(userDto, Role.ERole.ROLE_USER));
	}
	@PostMapping("/createAdmin")
	public ResponseEntity<User> registerAdmin(UserRequest userDto){
		return  ResponseEntity.ok(service.createUser(userDto, Role.ERole.ROLE_ADMIN));
	}
}
