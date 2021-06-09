package org.babareko.graduationBoot.web.data;

import org.babareko.graduationBoot.model.Restaurant;
import org.babareko.graduationBoot.model.Role;
import org.babareko.graduationBoot.model.User;
import org.babareko.graduationBoot.web.TestMatcher;

import java.util.List;

public class UserTestData {
    public static TestMatcher<User> User_MATCHER = TestMatcher.usingIgnoringFieldsComparator(User.class, "registered");

    public static final int User1_ID = 4;

    public static final User admin = new User(User1_ID, "Admin", "admin", List.of(Role.ADMIN, Role.USER));
    public static final User user = new User(User1_ID+1, "User", "1111", List.of(Role.USER));
    public static final User user2 = new User(User1_ID+2, "User2", "user", List.of(Role.USER));
}
