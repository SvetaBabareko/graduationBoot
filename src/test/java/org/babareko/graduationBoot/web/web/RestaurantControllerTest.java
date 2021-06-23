package org.babareko.graduationBoot.web.web;

import org.babareko.graduationBoot.model.Restaurant;
import org.babareko.graduationBoot.util.json.JsonUtil;
import org.babareko.graduationBoot.web.AbstractControllerTest;
import org.babareko.graduationBoot.web.RestaurantRestController;
import org.babareko.graduationBoot.web.TestUtil;
import org.babareko.graduationBoot.web.data.UserTestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.babareko.graduationBoot.web.data.RestaurantTestData.*;
import static org.springframework.test.annotation.DirtiesContext.MethodMode.BEFORE_METHOD;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class RestaurantControllerTest extends AbstractControllerTest {
    static final String URL = "/api/restaurants";

    @Autowired
    private RestaurantRestController restaurantRestController;

    @Test
    public void get() throws Exception {
        perform(MockMvcRequestBuilders.get(URL + "/8")
                .with(TestUtil.userHttpBasic(UserTestData.admin)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(RESTAURANT_MATCHER.contentJson(restaurant5));
    }

    @Test
    @DirtiesContext(methodMode = BEFORE_METHOD)
    public void getAll() throws Exception {
        perform(MockMvcRequestBuilders.get(URL + "/")
                .with(TestUtil.userHttpBasic(UserTestData.admin)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(RESTAURANT_MATCHER.contentJson(restaurantList));
    }


    @Test
    public void getForUser() throws Exception {
        perform(MockMvcRequestBuilders.get(URL + "/8")
                .with(TestUtil.userHttpBasic(UserTestData.user)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(RESTAURANT_MATCHER.contentJson(restaurant5));
    }

    @Test
    @DirtiesContext(methodMode = BEFORE_METHOD)
    public void getAllForUser() throws Exception {
        perform(MockMvcRequestBuilders.get(URL + "/")
                .with(TestUtil.userHttpBasic(UserTestData.user)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(RESTAURANT_MATCHER.contentJson(restaurantList));
    }

    @Test
    public void create() throws Exception {
        Restaurant expected = restaurantNew;
        ResultActions action = perform(MockMvcRequestBuilders.post(URL + "/")
                .with(TestUtil.userHttpBasic(UserTestData.admin))
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(expected)))
                .andExpect(status().isCreated());

        Restaurant created = TestUtil.readFromJson(action, Restaurant.class);
        Integer newId = created.getId();
        expected.setId(newId);

        RESTAURANT_MATCHER.assertMatch(created, expected);
        RESTAURANT_MATCHER.assertMatch(restaurantRestController.getAll(), restaurantListWithNew);
    }

    @Test
    @DirtiesContext(methodMode = BEFORE_METHOD)
    public void update() throws Exception {
        Restaurant updated = getUpdated();
        perform(MockMvcRequestBuilders.put(URL + "/12")
                .with(TestUtil.userHttpBasic(UserTestData.admin))
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated)))
                .andExpect(status().isNoContent());

        RESTAURANT_MATCHER.assertMatch(restaurantRestController.getAll(), restaurantList);
    }






}


