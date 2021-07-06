package org.babareko.graduationBoot.util;

import lombok.NoArgsConstructor;
import org.babareko.graduationBoot.model.Role;
import org.babareko.graduationBoot.model.User;
import org.babareko.graduationBoot.to.UserTo;

import java.util.List;

@NoArgsConstructor
public class UserUtil {

    public static User createNewFromTo(UserTo userTo) {
        return new User(null, userTo.getName(), userTo.getPassword(), List.of(Role.USER));
    }
}
