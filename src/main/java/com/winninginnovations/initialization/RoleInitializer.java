package com.winninginnovations.initialization;

import org.springframework.stereotype.Component;

import com.winninginnovations.entity.Role;
import com.winninginnovations.repository.RoleRepository;

import jakarta.annotation.PostConstruct;

@Component
public class RoleInitializer {

	private final RoleRepository roleRepository;

	public RoleInitializer(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@PostConstruct
	public void init() {
		if (roleRepository.findById(1L).isEmpty()) {
			Role adminRole = new Role();
			adminRole.setId(1L);
			adminRole.setName("ROLE_ADMIN");
			roleRepository.save(adminRole);
		}

		if (roleRepository.findById(2L).isEmpty()) {
			Role userRole = new Role();
			userRole.setId(2L);
			userRole.setName("ROLE_USER");
			roleRepository.save(userRole);
		}
	}
}
