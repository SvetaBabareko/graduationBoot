package org.babareko.graduationBoot.web;

import org.babareko.graduationBoot.AuthUser;
import org.babareko.graduationBoot.model.User;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AccountController.URL)
public class AccountController {
    static final String URL = "/api/account";

    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public User get(@AuthenticationPrincipal AuthUser authUser) {
        // log.info("get {}", authUser);
        // return ASSEMBLER.toModel(authUser.getUser());
        return authUser.getUser();
    }
}
