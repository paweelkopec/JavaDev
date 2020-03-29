package com.pawelk.javadev.controllers;


import com.pawelk.javadev.models.Activity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ActivityControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private  ActivityController activityController;


    @Test
    public void all() throws  Exception{

        Activity activity = new Activity();
        long id = 2;
        activity.setId(id);
        activity.setTitle("Java Dev 2");

        List<Activity> list = new ArrayList<>();
        list.add(activity);

        given(activityController.all()).willReturn(list);

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .get("/activity/")
                .with(user("admin").password("admin"))
                .contentType(MediaType.APPLICATION_JSON);

        mvc.perform(builder)
           .andExpect(status().isOk())
                .andExpect(content().string(containsString("Java Dev 2")));

    }

    @Test
    public void one() throws  Exception{
        Activity activity = new Activity();
        long id = 2;
        activity.setId(id);
        activity.setTitle("Java Dev 3");

        given(activityController.one(activity.getId())).willReturn(activity);

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .get("/activity/"+activity.getId())
                .with(user("admin").password("admin"))
                .contentType(MediaType.APPLICATION_JSON);

        mvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("title", is(activity.getTitle())));
    }

}