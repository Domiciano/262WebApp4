package edu.co.icesi.introspringboot.service.impl;

import edu.co.icesi.introspringboot.entity.Role;
import edu.co.icesi.introspringboot.repo.RolePermissionRepository;
import edu.co.icesi.introspringboot.repo.RoleRepository;
import edu.co.icesi.introspringboot.repo.UserRoleRepository;
import edu.co.icesi.introspringboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(Integer id) {
        return roleRepository.findById(id);
    }

    @Override
    @Transactional
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        roleRepository.deleteById(id);
        userRoleRepository.deleteByRole_Id(id);
        rolePermissionRepository.deleteByRole_Id(id);
    }
}
