package ru.gb.dev.spring.pfs.statistics.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.gb.dev.spring.pfs.statistics.controller.base.AbstractControllerTest;
import ru.gb.dev.spring.pfs.statistics.model.dto.LogoDto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LogoControllerTest_MockMvc extends AbstractControllerTest {

    private final String uri = "/api/logos";

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void whenGetLogos_thenGetLogoList() throws Exception {
        // given

        // when
        final MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        final int status = mvcResult.getResponse().getStatus();
        final String content = mvcResult.getResponse().getContentAsString();
        final LogoDto[] logos = super.mapFromJson(content, LogoDto[].class);

        // then
        assertEquals(HttpStatus.OK.value(), status);
        assertTrue(logos.length > 0);
    }

    @Test
    public void whenLogoPost_thenLogoCreated() throws Exception {
        // given
        final LogoDto logo = new LogoDto();
        logo.setName("TestLogo");
        logo.setExtension("TestLogoExtension");
        logo.setPath("TestLogoPath");

        // when
        String inputJson = super.mapToJson(logo);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        final String content = mvcResult.getResponse().getContentAsString();

        // then
        assertEquals(HttpStatus.CREATED.value(), status);
        assertEquals("Logo is created successfully", content);
    }

    @Test
    public void whenLogoPut_thenLogoUpdated() throws Exception {
        // given
        final LogoDto logo = new LogoDto();
        logo.setName("TestLogoUpdated");
        logo.setExtension("TestLogoExtension");
        logo.setPath("TestLogoPath");
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        LogoDto[] logos = super.mapFromJson(content, LogoDto[].class);
        String id = logos[0].getId();

        // when
        String inputJson = super.mapToJson(logo);
        mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri + "/" + id)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        content = mvcResult.getResponse().getContentAsString();

        // then
        assertEquals(HttpStatus.OK.value(), status);
        assertEquals("Logo is updated successfully", content);
    }

}
