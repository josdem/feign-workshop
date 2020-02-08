package com.jos.dem.feign.workshop;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jos.dem.feign.workshop.service.UserService;
import java.util.List;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;

import org.springframework.beans.factory.annotation.Autowired;

import retrofit2.Call;
import retrofit2.Response;

import com.jos.dem.feign.workshop.model.SSHKey;
import com.jos.dem.feign.workshop.model.PublicEmail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserTest extends UserIntegrationTest {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private UserService userService;

  @Before
  public void setup() {
    log.info("Before any test execution");
  }

  @Then("User gets his public keys")
  public void shouldGetKeys() throws Exception {
    log.info("Running: User gets his SSH keys");

    Call<List<SSHKey>> call = userService.getKeys();
    Response<List<SSHKey>> response = call.execute();
    List<SSHKey> keys = response.body();
    assertTrue(keys.size() > 3, "Should be more than 3 keys");
  }

  @Then("^User gets his public emails$")
  public void shouldGetEmails() throws Exception {
    log.info("Validating collection integrity");

    Call<List<PublicEmail>> call = userService.getEmails();
    Response<List<PublicEmail>> response = call.execute();
    List<PublicEmail> emails = response.body();

    assertFalse(emails.isEmpty(), () -> "Should not be empty");
    assertTrue(emails.size() == 1,  () -> "Should be 1 email");

    PublicEmail email = emails.get(0);
    log.info("Validating email attributes");
      assertAll("email",
        () -> assertEquals("joseluis.delacruz@gmail.com", email.getEmail(), "Should contains josdem's email"),
        () -> assertTrue(email.isVerified(), "Should be verified"),
        () -> assertTrue(email.isPrimary(), "Should be primary"),
        () -> assertEquals("public", email.getVisibility(), "Should be public")
      );
  }

  @After
  public void tearDown() {
    log.info("After all test execution");
  }

}
