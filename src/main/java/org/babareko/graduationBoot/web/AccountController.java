package org.babareko.graduationBoot.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.babareko.graduationBoot.AuthUser;
import org.babareko.graduationBoot.model.Role;
import org.babareko.graduationBoot.model.User;
import org.babareko.graduationBoot.repository.UserRepository;
import org.babareko.graduationBoot.service.UserService;
import org.babareko.graduationBoot.to.UserTo;
import org.babareko.graduationBoot.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.EnumSet;
import java.util.List;

import static org.babareko.graduationBoot.util.ValidationUtil.assureIdConsistent;

@RestController
@RequestMapping(AccountController.URL)
//@AllArgsConstructor
@Slf4j
public class AccountController {
    static final String URL = "/api/account";

    // private final UserRepository userRepository;

    private final UserService userService;

    @Autowired
    public AccountController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public User get(@AuthenticationPrincipal AuthUser authUser) {
        int id = authUser.id();
        log.info("get {}", authUser);
        return userService.get(id);
    }


    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<User> register(@Valid @RequestBody User user) {
        log.info("register {}", user);
        ValidationUtil.checkNew(user);
        user.setRoles(EnumSet.of(Role.USER));
        user = userService.save(user);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/account")
                .build().toUri();
        return ResponseEntity.created(uriOfNewResource).body(user);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CacheEvict(value = "users", key = "#authUser.username")
    public void delete(@AuthenticationPrincipal AuthUser authUser) {
        log.info("delete {}", authUser);
        userService.deleteById(authUser.id());
    }

    public List<User> getAll() {
        return userService.getAll();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
   // @CachePut(value = "users", key = "#authUser.username")
    public void update(@Valid @RequestBody UserTo userTo, @AuthenticationPrincipal AuthUser authUser) {
        log.info("update {} to {}", authUser, userTo);

        int id = authUser.id();
        log.info("update {} with id={}", userTo, id);
        assureIdConsistent(userTo, id);
        //return userService.update(userTo);
    }
}
