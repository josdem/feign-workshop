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

import com.jos.dem.feign.workshop.model.LabelResponse;
import com.jos.dem.feign.workshop.util.LabelCreator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LabelUpdateTest extends LabelIntegrationTest {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private LabelService labelService;
  @Autowired
  private LabelCreator labelCreator;

  @Before
  public void setup() {
    log.info("Before any test execution");
  }

  @Then("User updates label")
  public void shouldUpdateLabel() throws Exception {
    log.info("Running: User updates label");

    Call<LabelResponse> call = labelService.update(labelCreator.update(), "cucumber");
    Response<LabelResponse> response = call.execute();
    LabelResponse label = response.body();

    assertAll("response",
      () -> assertEquals("spock", label.getName()),
      () -> assertEquals("ff0000", label.getColor())
    );
  }

  @After
  public void tearDown() {
    log.info("After all test execution");
  }

}

