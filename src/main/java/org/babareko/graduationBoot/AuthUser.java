package org.babareko.graduationBoot;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import org.babareko.graduationBoot.facade.UserFacade;
import org.babareko.graduationBoot.model.User;
import org.babareko.graduationBoot.to.UserTo;

@Getter
@ToString(of = "user")
public class AuthUser extends org.springframework.security.core.userdetails.User{
    private final UserTo userTo;

    public AuthUser(@NonNull User user) {
        super(user.getName(), user.getPassword(), user.getRoles());
        this.userTo = UserFacade.userToUserTO(user);
    }

    public int id() {
        return userTo.getId();
    }
}
