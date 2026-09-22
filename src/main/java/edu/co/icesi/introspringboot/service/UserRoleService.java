package edu.co.icesi.introspringboot.service;

import edu.co.icesi.introspringboot.entity.UserRole;
import edu.co.icesi.introspringboot.entity.keys.UserRoleId;
import edu.co.icesi.introspringboot.repo.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    public List<UserRole> findAll() {
        return userRoleRepository.findAll();
    }

    public Optional<UserRole> findById(UserRoleId id) {
        return userRoleRepository.findById(id);
    }

    @Transactional
    public UserRole save(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Transactional
    public void deleteById(UserRoleId id) {
        userRoleRepository.deleteById(id);
    }
}
