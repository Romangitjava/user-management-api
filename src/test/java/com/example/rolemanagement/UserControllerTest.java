package com.example.rolemanagement;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.example.rolemanagement.entity.User;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class UserControllerTest  extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void addUser() throws Exception {
        String uri = "/users";
        User user = new User();
        user.setUsername("User");
        user.setLogin("user");
        user.setPassword("Q123");

        String inputJson = super.mapToJson(user);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals(content, "{\"id\":1000,\"username\":\"User\"," +
                "\"login\":\"user\",\"password\":\"Q123\",\"roles\":null}");
    }
    @Test
    public void editUser() throws Exception {
        String uri = "/users/1";
        User user = new User();
        user.setUsername("Pit");
        user.setLogin("user");
        user.setPassword("Q123");
        String inputJson = super.mapToJson(user);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals(content, "{\"id\":1,\"username\":\"Pit\"," +
                "\"login\":\"user\",\"password\":\"Q123\",\"roles\":null}");

    }
    @Test
    public void deleteUser() throws Exception {
        String uri = "/users/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(200, status);
    }
}

