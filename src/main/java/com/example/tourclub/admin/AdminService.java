package com.example.tourclub.admin;

import com.example.tourclub.admin.dto.SetRoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public void setUserRole(SetRoleDTO setRoleDTO) {

    }

}
