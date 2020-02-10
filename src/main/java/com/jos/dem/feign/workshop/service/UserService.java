package com.jos.dem.feign.workshop.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import retrofit2.Call;
import retrofit2.http.GET;

import com.jos.dem.feign.workshop.model.SSHKey;
import com.jos.dem.feign.workshop.model.PublicEmail;

public interface UserService {

  @RequestMapping(method = RequestMethod.GET, value ="users/josdem/keys")
  List<SSHKey> getKeys();

  @RequestMapping(method = RequestMethod.GET, value ="user/public_emails")
  List<PublicEmail> getEmails();

}
