package com.jos.dem.feign.workshop.service;

import com.jos.dem.feign.workshop.model.Label;
import com.jos.dem.feign.workshop.model.LabelResponse;
import feign.Param;
import feign.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface LabelService {

  @RequestMapping(method = RequestMethod.POST, value = "repos/josdem/retrofit-workshop/labels")
  LabelResponse create(Label label);
  @RequestMapping(method = RequestMethod.PATCH, value ="repos/josdem/retrofit-workshop/labels/{name}")
  LabelResponse update(Label label, @Param("name") String name);
  @RequestMapping(method = RequestMethod.DELETE, value = "repos/josdem/retrofit-workshop/labels/{name}")
  Response delete(@Param("name") String name);


}
