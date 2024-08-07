package com.gani.merchantcustomer.service.implementation;

import com.gani.merchantcustomer.constant.UserRole;
import com.gani.merchantcustomer.dto.request.LoginRequest;
import com.gani.merchantcustomer.dto.request.RegisterCustomerRequest;
import com.gani.merchantcustomer.dto.request.RegisterMerchantRequest;
import com.gani.merchantcustomer.dto.response.LoginResponse;
import com.gani.merchantcustomer.dto.response.RegisterResponse;
import com.gani.merchantcustomer.entity.Role;
import com.gani.merchantcustomer.entity.User;
import com.gani.merchantcustomer.entity.UserAccount;
import com.gani.merchantcustomer.repository.UserAccountRepository;
import com.gani.merchantcustomer.security.JwtUtil;
import com.gani.merchantcustomer.service.*;
import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final RoleService roleService;
    private final CustomerService customerService;
    private final MerchantService merchantService;
    private final UserService userService;
    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public RegisterResponse registerCustomer(RegisterCustomerRequest request) {
        Role role = roleService.getOrSave(UserRole.ROLE_CUSTOMER);
        UserAccount userAccount = UserAccount.builder()
                .role(role)
                .password(passwordEncoder.encode(request.getPassword()))
                .username(request.getUsername())
                .build();

        this.validateNotAuthenticated(userAccount);
        userAccountRepository.save(userAccount);
        customerService.create(userAccount, request);

        return RegisterResponse.builder()
                .role(userAccount.getRole().getRole().name())
                .username(userAccount.getUsername())
                .build();
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public RegisterResponse registerMerchant(RegisterMerchantRequest request) {
        Role role = roleService.getOrSave(UserRole.ROLE_MERCHANT);
        UserAccount userAccount = UserAccount.builder()
                .role(role)
                .password(passwordEncoder.encode(request.getPassword()))
                .username(request.getUsername())
                .build();

        this.validateNotAuthenticated(userAccount);
        userAccountRepository.save(userAccount);
        merchantService.create(userAccount, request);

        return RegisterResponse.builder()
                .role(userAccount.getRole().getRole().name())
                .username(userAccount.getUsername())
                .build();
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        Authentication authentication =authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )

        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = (User) authentication.getPrincipal();
        String token = jwtUtil.generateToken(user);

        return LoginResponse.builder()
                .token(token)
                .username(user.getUsername())
                .role(user.getRole().name())
                .build();
    }

    @Override
    public void validateNotAuthenticated(UserAccount userAccount) {
        UserAccount userAccount1 = userService.getUserByUsername(userAccount.getUsername());
        if (userAccount1 != null) {
            throw new ValidationException("User already exists");
        }
    }
}
