package org.babareko.graduationBoot.facade;

import org.babareko.graduationBoot.model.User;
import org.babareko.graduationBoot.to.UserTo;
import org.springframework.stereotype.Component;

@Component
public class UserFacade {

    public UserTo userToUserTO(User user){
        UserTo userTo = new UserTo();
        userTo.setId(user.getId());
        userTo.setName(user.getName());
        userTo.setPassword(user.getPassword());
        return userTo;
    }

}
