package com.jos.dem.feign.workshop;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.jos.dem.feign.workshop.model.PublicEmail;
import com.jos.dem.feign.workshop.service.UserService;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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

    assertTrue(userService.getKeys().size() > 3, "Should be more than 3 keys");
  }

  @Then("^User gets his public emails$")
  public void shouldGetEmails() throws Exception {
    log.info("Validating collection integrity");

    List<PublicEmail> emails = userService.getEmails();

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
