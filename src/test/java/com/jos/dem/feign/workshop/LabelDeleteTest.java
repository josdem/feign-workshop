package com.jos.dem.feign.workshop;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jos.dem.feign.workshop.service.LabelService;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;

import retrofit2.Call;
import retrofit2.Response;

import org.springframework.beans.factory.annotation.Autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LabelDeleteTest extends LabelIntegrationTest {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private LabelService labelService;

  @Before
  public void setup() {
    log.info("Before any test execution");
  }

  @Then("User deletes label")
  public void shouldUpdateLabel() throws Exception {
    log.info("Running: User updates label");

    Call<Response<Void>> call = labelService.delete("spock");
    Response<Response<Void>> response = call.execute();
    assertEquals(204, response.code());

  }

  @After
  public void tearDown() {
    log.info("After all test execution");
  }

}

