package org.babareko.graduationBoot;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import org.babareko.graduationBoot.model.User;

@Getter
@ToString(of = "user")
public class AuthUser extends org.springframework.security.core.userdetails.User{
    private final User user;

    public AuthUser(@NonNull User user) {
        super(user.getName(), user.getPassword(), user.getRoles());
        this.user = user;
    }

    public int id() {
        return user.getId();
    }
}
