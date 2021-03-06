package org.babareko.graduationBoot.web.web;

import org.babareko.graduationBoot.model.User;
import org.babareko.graduationBoot.repository.UserRepository;
import org.babareko.graduationBoot.service.UserService;
import org.babareko.graduationBoot.to.UserTo;
import org.babareko.graduationBoot.util.UserUtil;
import org.babareko.graduationBoot.util.json.JsonUtil;
import org.babareko.graduationBoot.web.AbstractControllerTest;
import org.babareko.graduationBoot.web.AccountController;
import org.babareko.graduationBoot.web.TestUtil;
import org.babareko.graduationBoot.web.data.UserTestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.babareko.graduationBoot.web.data.UserTestData.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class UserControllerTest extends AbstractControllerTest {

    static final String URL = "/api/account";

    @Autowired
    protected UserService userService;

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    private AccountController accountController;

    @Test
    public void get() throws Exception {
        perform(MockMvcRequestBuilders.get(URL + "/")
                .with(TestUtil.userHttpBasic(UserTestData.user)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(USER_MATCHER.contentJson(user));
    }

    @Test
    public void register() throws Exception {
        UserTo newUserTo = getNew();

        ResultActions action = perform(MockMvcRequestBuilders.post(URL + "/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newUserTo)))
                .andDo(print())
                .andExpect(status().isCreated());

        User returned = TestUtil.readFromJson(action, User.class);
        User created = UserUtil.createNewFromTo(newUserTo);
        Integer newId = returned.getId();
        created.setId(newId);

        USER_MATCHER.assertMatch(created, returned);
        USER_MATCHER.assertMatch(userService.get(newId), returned);
    }


    @Test
    public void updateProfile() throws Exception {
        UserTo updatedTo = getUpdated();
        perform(MockMvcRequestBuilders.put(URL).contentType(MediaType.APPLICATION_JSON)
                .with(TestUtil.userHttpBasic(user2))
                .content(JsonUtil.writeValue(updatedTo)))
                .andDo(print())
                .andExpect(status().isNoContent());
        USER_MATCHER.assertMatch(accountController.getAll(), List.of(admin, user, user2));
        USER_MATCHER.assertMatch(userService.get(updatedTo.getId()), user2);
    }

    @Test
    public void delete() throws Exception {
        perform(MockMvcRequestBuilders.delete(URL)
                .with(TestUtil.userHttpBasic(user)))
                .andExpect(status().isNoContent());
        USER_MATCHER.assertMatch(accountController.getAll(), List.of(admin, user2));
    }

    @Test
    public void getUnAuth() throws Exception {
        perform(MockMvcRequestBuilders.get(URL))
                .andExpect(status().isUnauthorized());
    }


}
