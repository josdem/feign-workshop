package com.jos.dem.feign.workshop.service;

import com.jos.dem.feign.workshop.model.PublicEmail;
import com.jos.dem.feign.workshop.model.SSHKey;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="UserService", url= "${github.api.url}")
public interface UserService {

  @RequestMapping(method = RequestMethod.GET, value ="users/josdem/keys")
  List<SSHKey> getKeys();

  @RequestMapping(method = RequestMethod.GET, value ="user/public_emails")
  List<PublicEmail> getEmails();

}
