package org.babareko.graduationBoot.web.web;

import org.babareko.graduationBoot.web.AbstractControllerTest;
import org.babareko.graduationBoot.web.AccountController;
import org.babareko.graduationBoot.web.RestaurantRestController;
import org.babareko.graduationBoot.web.TestUtil;
import org.babareko.graduationBoot.web.data.UserTestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.babareko.graduationBoot.web.data.UserTestData.*;

@RunWith(SpringRunner.class)
public class UserControllerTest extends AbstractControllerTest {

    static final String URL = "/api/account";

    @Autowired
    private AccountController accountController;

    @Test
    public void get() throws Exception {
        perform(MockMvcRequestBuilders.get(URL+"/")
                .with(TestUtil.userHttpBasic(UserTestData.user)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(USER_MATCHER.contentJson(user));
    }
}
