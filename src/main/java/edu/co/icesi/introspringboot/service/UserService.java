package edu.co.icesi.introspringboot.service;

import edu.co.icesi.introspringboot.entity.User;
import edu.co.icesi.introspringboot.repo.UserRepository;
import edu.co.icesi.introspringboot.repo.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
        userRoleRepository.deleteByUser_Id(id);
    }
}
