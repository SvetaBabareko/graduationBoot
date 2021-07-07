package org.babareko.graduationBoot.service;


import org.babareko.graduationBoot.AuthUser;
import org.babareko.graduationBoot.model.User;
import org.babareko.graduationBoot.repository.UserRepository;
import org.babareko.graduationBoot.to.UserTo;
import org.babareko.graduationBoot.util.exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.List;

import static org.babareko.graduationBoot.config.WebSecurityConfig.PASSWORD_ENCODER;


@Service
public class UserService implements UserDetailsService {
    public static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final PasswordEncoder  passwordEncoder;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.passwordEncoder = PASSWORD_ENCODER;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userRepository.findByName(name).orElseThrow(
                ()->new UsernameNotFoundException("User "+name+"is not found"));
        return  new AuthUser(user);
    }

    public User get(int id) {
        return userRepository.findById(id).orElseThrow(
                ()->new UserNotFoundException("User "+id+"is not found"));
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void update(UserTo userTo) {
        Assert.notNull(userTo, "User must not be null");
        User user = get(userTo.getId());
        user.setName(userTo.getName());
        String password = user.getPassword();
        user.setPassword(StringUtils.hasText(password) ? passwordEncoder.encode(password) : password);
    }
}
