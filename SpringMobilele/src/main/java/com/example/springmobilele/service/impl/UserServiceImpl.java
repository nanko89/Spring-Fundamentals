package com.example.springmobilele.service.impl;

import com.example.springmobilele.models.entity.User;
import com.example.springmobilele.models.entity.UserRole;
import com.example.springmobilele.models.entity.enums.Role;
import com.example.springmobilele.models.service.UserLoginServiceModel;
import com.example.springmobilele.repository.UserRepository;
import com.example.springmobilele.repository.UserRoleRepository;
import com.example.springmobilele.service.UserService;
import com.example.springmobilele.user.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository, UserRoleRepository userRoleRepository, CurrentUser currentUser) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.currentUser = currentUser;
    }

    @Override
    public void initializeUserAndRole() {

        initializeRoles();
        initializeUsers();

    }

    private void initializeUsers() {
        if (userRepository.count() == 0) {

            UserRole adminRole = userRoleRepository.findByRole(Role.ADMIN);
            UserRole userRole = userRoleRepository.findByRole(Role.USER);

            User admin = new User();
            admin
                    .setUsername("admin")
                    .setPassword(passwordEncoder.encode("test"))
                    .setFirstName("Georgy")
                    .setLastName("Georgiev")
                    .setActive(true);

            admin.setUserRole(Set.of(adminRole, userRole));
            userRepository.save(admin);

            User pesho = new User();
            pesho
                    .setUsername("pesho")
                    .setPassword(passwordEncoder.encode("test"))
                    .setFirstName("Petur")
                    .setLastName("Petrov")
                    .setActive(true);

            pesho.setUserRole(Set.of(userRole));
            userRepository.saveAll(List.of(admin, pesho));
        }
    }

    private void initializeRoles() {

        if (userRoleRepository.count() == 0) {
            UserRole adminRole = new UserRole();
            adminRole.setRole(Role.ADMIN);

            UserRole userRole = new UserRole();
            userRole.setRole(Role.USER);

            userRoleRepository.saveAll(List.of(adminRole, userRole));
        }
    }

    @Override
    public boolean login(UserLoginServiceModel userLoginServiceModel) {

        Optional<User> userOptional = userRepository
                .findByUsername(userLoginServiceModel
                        .getUsername());

        if (userOptional.isEmpty()) {
            logout();
            return false;
        } else {
            boolean success = passwordEncoder
                    .matches(userLoginServiceModel.getPassword(), userOptional.get().getPassword());
            if (success) {
                User loggedUser = userOptional.get();

                currentUser.setLoggedIn(true)
                        .setUsername(loggedUser.getUsername())
                        .setFirstName(loggedUser.getFirstName())
                        .setLastName(loggedUser.getLastName());

                loggedUser.getUserRole().forEach(role -> currentUser.addRole(role.getRole()));
            }
            return success;
        }
    }

    @Override
    public boolean logout() {
        currentUser.clean();
        return false;
    }
}
