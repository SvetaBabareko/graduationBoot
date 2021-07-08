package org.babareko.graduationBoot.web.web;

import org.babareko.graduationBoot.model.Dish;
import org.babareko.graduationBoot.util.json.JsonUtil;
import org.babareko.graduationBoot.web.AbstractControllerTest;
import org.babareko.graduationBoot.web.DishRestController;
import org.babareko.graduationBoot.web.TestUtil;
import org.babareko.graduationBoot.web.data.UserTestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.babareko.graduationBoot.web.data.DishTestData.*;
import static org.springframework.test.annotation.DirtiesContext.MethodMode.BEFORE_METHOD;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class DishControllerTest extends AbstractControllerTest {
    static final String URL = "/api/dishes";

    @Autowired
    private DishRestController dishRestController;

    @Test
    @DirtiesContext(methodMode = BEFORE_METHOD)
    public void getAllForAdmin() throws Exception {
        perform(MockMvcRequestBuilders.get(URL + "/")
                .with(TestUtil.userHttpBasic(UserTestData.admin)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(DISH_MATCHER.contentJson(dishList));
    }

    @Test
    @DirtiesContext(methodMode = BEFORE_METHOD)
    public void getAllForRestaurant()throws Exception {
        perform(MockMvcRequestBuilders.get(URL + "/restaurant/4")
                .with(TestUtil.userHttpBasic(UserTestData.admin)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(DISH_MATCHER.contentJson(dishListForRestaurant4));
    }

    @Test
    @DirtiesContext(methodMode = BEFORE_METHOD)
    public void getAllForUser() throws Exception {
        perform(MockMvcRequestBuilders.get(URL + "/4")
                .with(TestUtil.userHttpBasic(UserTestData.user)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(DISH_MATCHER.contentJson(dishList));
    }


    @Test
    public void getForAdmin() throws Exception {
        perform(MockMvcRequestBuilders.get(URL + "/26")
                .with(TestUtil.userHttpBasic(UserTestData.admin)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(DISH_MATCHER.contentJson(dish13));
    }

    @Test
    public void getForUser() throws Exception {
        perform(MockMvcRequestBuilders.get(URL + "/26")
                .with(TestUtil.userHttpBasic(UserTestData.user)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(DISH_MATCHER.contentJson(dish13));
    }

    @Test
    public void deleteForAdmin() throws Exception {
        perform(MockMvcRequestBuilders.delete(URL + "/16")
                .with(TestUtil.userHttpBasic(UserTestData.admin)))
                .andDo(print())
                .andExpect(status().isNoContent());

        DISH_MATCHER.assertMatch(dishRestController.getAll(), dishListWithDelete);
    }

    @Test
    public void deleteForUser() throws Exception {
        perform(MockMvcRequestBuilders.delete(URL + "/17")
                .with(TestUtil.userHttpBasic(UserTestData.user)))
                .andDo(print())
                .andExpect(status().isForbidden());

    }

    @Test
    public void createForAdmin() throws Exception {
        Dish expected = dishNew;
        ResultActions action = perform(MockMvcRequestBuilders.post(URL + "/4")
                .with(TestUtil.userHttpBasic(UserTestData.admin))
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(expected)))
                .andExpect(status().isCreated());

        Dish created = TestUtil.readFromJson(action, Dish.class);
        Integer newId = created.getId();
        expected.setId(newId);

        DISH_MATCHER.assertMatch(created, expected);
        DISH_MATCHER.assertMatch(dishRestController.getAll(), dishListWithNew);
    }


}
