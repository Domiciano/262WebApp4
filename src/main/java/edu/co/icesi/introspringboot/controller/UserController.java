package edu.co.icesi.introspringboot.controller;


import edu.co.icesi.introspringboot.entity.Student;
import edu.co.icesi.introspringboot.entity.User;
import edu.co.icesi.introspringboot.repo.StudentRepository;
import edu.co.icesi.introspringboot.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/labx")
    public List<User> labx() {
        return userRepository.findDistinctByUserRoles_Role_RolePermissions_Permission_Name(
                "CREATE_STUDENT"
        );
    }


}