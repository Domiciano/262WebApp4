package edu.co.icesi.introspringboot.service.impl;

import edu.co.icesi.introspringboot.entity.UserRole;
import edu.co.icesi.introspringboot.entity.keys.UserRoleId;
import edu.co.icesi.introspringboot.repo.UserRoleRepository;
import edu.co.icesi.introspringboot.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public List<UserRole> findAll() {
        return userRoleRepository.findAll();
    }

    @Override
    public Optional<UserRole> findById(UserRoleId id) {
        return userRoleRepository.findById(id);
    }

    @Override
    @Transactional
    public UserRole save(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    @Transactional
    public void deleteById(UserRoleId id) {
        userRoleRepository.deleteById(id);
    }
}
