package edu.co.icesi.introspringboot.service;

import edu.co.icesi.introspringboot.entity.Role;
import edu.co.icesi.introspringboot.repo.RolePermissionRepository;
import edu.co.icesi.introspringboot.repo.RoleRepository;
import edu.co.icesi.introspringboot.repo.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Optional<Role> findById(Integer id) {
        return roleRepository.findById(id);
    }

    @Transactional
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Transactional
    public void deleteById(Integer id) {
        roleRepository.deleteById(id);
        userRoleRepository.deleteByRole_Id(id);
        rolePermissionRepository.deleteByRole_Id(id);
    }
}
