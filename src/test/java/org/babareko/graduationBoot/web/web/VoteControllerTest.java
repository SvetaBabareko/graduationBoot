package org.babareko.graduationBoot.web.web;

import org.babareko.graduationBoot.web.AbstractControllerTest;
import org.babareko.graduationBoot.web.RestaurantRestController;
import org.babareko.graduationBoot.web.TestUtil;
import org.babareko.graduationBoot.web.VoteRestController;
import org.babareko.graduationBoot.web.data.UserTestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.babareko.graduationBoot.web.data.VoteTestData.VOTE_MATCHER;
import static org.babareko.graduationBoot.web.data.VoteTestData.voteList;
import static org.springframework.test.annotation.DirtiesContext.MethodMode.BEFORE_METHOD;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class VoteControllerTest extends AbstractControllerTest {
    static final String URL = "/api/votes";

    @Autowired
    private VoteRestController voteRestController;

    @Test
    @DirtiesContext(methodMode = BEFORE_METHOD)
    public void getAll() throws Exception {
        perform(MockMvcRequestBuilders.get(URL + "/")
                .with(TestUtil.userHttpBasic(UserTestData.admin)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(VOTE_MATCHER.contentJson(voteList));
    }
}
