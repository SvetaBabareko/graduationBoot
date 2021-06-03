package org.babareko.graduationBoot.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.babareko.graduationBoot.AuthUser;
import org.babareko.graduationBoot.model.Role;
import org.babareko.graduationBoot.model.User;
import org.babareko.graduationBoot.repository.UserRepository;
import org.babareko.graduationBoot.util.ValidationUtil;
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

import javax.swing.text.html.parser.Entity;
import javax.validation.Valid;
import java.net.URI;
import java.util.EnumSet;

@RestController
@RequestMapping(AccountController.URL)
@AllArgsConstructor
@Slf4j
public class AccountController {
    static final String URL = "/api/account";

    private final UserRepository userRepository;

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public User get(@AuthenticationPrincipal AuthUser authUser) {
         log.info("get {}", authUser);
        // return ASSEMBLER.toModel(authUser.getUser());
        return authUser.getUser();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CacheEvict(value = "users", key = "#authUser.username")
    public void delete(@AuthenticationPrincipal AuthUser authUser) {
        log.info("delete {}", authUser);
        userRepository.deleteById(authUser.id());
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<User> register(@Valid @RequestBody User user) {
        log.info("register {}", user);
        ValidationUtil.checkNew(user);
        user.setRoles(EnumSet.of(Role.USER));
        user = userRepository.save(user);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/account")
                .build().toUri();
        return ResponseEntity.created(uriOfNewResource).body(user);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CachePut(value = "users", key = "#authUser.username")
    public User update(@Valid @RequestBody User user, @AuthenticationPrincipal AuthUser authUser) {
        log.info("update {} to {}", authUser, user);
        User oldUser = authUser.getUser();
        ValidationUtil.assureIdConsistent(user, oldUser.getId());
        user.setRoles(oldUser.getRoles());
        if (user.getPassword() == null) {
            user.setPassword(oldUser.getPassword());
        }
        return userRepository.save(user);
    }
}
