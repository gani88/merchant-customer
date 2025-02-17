package com.gani.merchantcustomer.repository;

import com.gani.merchantcustomer.constant.UserRole;
import com.gani.merchantcustomer.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

    Optional<Role> findByRole(UserRole role);
}
