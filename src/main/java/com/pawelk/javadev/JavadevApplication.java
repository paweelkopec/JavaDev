package com.pawelk.javadev;

import com.pawelk.javadev.models.Role;
import com.pawelk.javadev.models.User;
import com.pawelk.javadev.repositories.RoleRepository;
import com.pawelk.javadev.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class JavadevApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavadevApplication.class, args);
	}


	private static final Logger log = LoggerFactory.getLogger(JavadevApplication.class);

	@Bean
	public CommandLineRunner defaultUser(UserRepository userRepository, RoleRepository roleRepository) {
			return (args) -> {
                //admin role
                if(roleRepository.countByName("ROLE_ADMIN")==0){
                    log.info("Create default role admin");
                        Role role = new Role();
                        role.setName("ROLE_ADMIN");
                        roleRepository.save(role);
                        log.info("-------------------------------");
                }
                Role adminRole = roleRepository.findByName("ROLE_ADMIN");
                //user role
                if(roleRepository.countByName("ROLE_USER")==0){
                    log.info("Create default role user");
                    Role role = new Role();
                    role.setName("ROLE_USER");
                    roleRepository.save(role);
                    log.info("-------------------------------");
                }
                Role userRole = roleRepository.findByName("ROLE_USER");
                //create users
                BCryptPasswordEncoder encoder = new  BCryptPasswordEncoder();
                //ADMIN
			    if(userRepository.countByEmail("admin")==0){
                    log.info("Create default admin");
                    User user = new User();
                    user.setFirstname("admin");
                    user.setLastname("Admin");
                    user.setEmail("admin");
                    user.setPassword(encoder.encode("admin"));
                    user.setRoles(Arrays.asList(adminRole));
                    userRepository.save(user);
                    log.info("-------------------------------");
                }
			    //USER
                if(userRepository.countByEmail("user")==0){
                    log.info("Create defaul user");
                    User user = new User();
                    user.setFirstname("user");
                    user.setLastname("User");
                    user.setEmail("user");
                    user.setPassword(encoder.encode("user"));
                    user.setRoles(Arrays.asList(userRole));
                    userRepository.save(user);
                    log.info("-------------------------------");
                }
			};
	}
}
