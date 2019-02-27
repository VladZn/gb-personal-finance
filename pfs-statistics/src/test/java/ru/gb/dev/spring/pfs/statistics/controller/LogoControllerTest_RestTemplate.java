package ru.gb.dev.spring.pfs.statistics.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.gb.dev.spring.pfs.statistics.controller.dto.ResultDto;
import ru.gb.dev.spring.pfs.statistics.model.dto.LogoDto;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LogoControllerTest_RestTemplate {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void whenLogosPing_thenSuccess() throws Exception {
        // given

        // when
        final ResponseEntity<ResultDto> entity = restTemplate.getForEntity("/api/logos/ping", ResultDto.class);
        final ResultDto resultDto = entity.getBody();

        // then
        Assert.assertTrue(entity.getStatusCode() == HttpStatus.OK);
        Assert.assertNotNull(resultDto);
        Assert.assertNotNull(resultDto.getSuccess());
    }

    @Test
    public void whenLogoPost_thenSuccess() throws Exception {
        // given
        LogoDto logo = new LogoDto();
        logo.setName("TestLogo");
        logo.setExtension("TestLogoExtension");
        logo.setPath("TestLogoPath");

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");

        HttpEntity<LogoDto> request = new HttpEntity<>(logo, headers);

        // when
        final ResponseEntity<ResultDto> entity = restTemplate.postForEntity("/api/logos", request, ResultDto.class);
        final ResultDto resultDto = entity.getBody();

        // then
        Assert.assertTrue(entity.getStatusCode() == HttpStatus.OK);
        Assert.assertNotNull(resultDto);
        Assert.assertNotNull(resultDto.getSuccess());
    }

}
