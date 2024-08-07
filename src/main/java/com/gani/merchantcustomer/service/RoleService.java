package com.gani.merchantcustomer.service;

import com.gani.merchantcustomer.constant.UserRole;
import com.gani.merchantcustomer.entity.Role;

public interface RoleService {
    Role getOrSave(UserRole role);
}
