package com.jos.dem.feign.workshop.service;

import com.jos.dem.feign.workshop.model.Label;
import com.jos.dem.feign.workshop.model.LabelResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Path;

public interface LabelService {

  @RequestMapping(method = RequestMethod.POST, value = "repos/josdem/retrofit-workshop/labels")
  LabelResponse create(@Body Label label);
  @RequestMapping(method = RequestMethod.PATCH, value ="repos/josdem/retrofit-workshop/labels/{name}")
  LabelResponse update(@Body Label label, @Path("name") String name);
  @RequestMapping(method = RequestMethod.DELETE, value = "repos/josdem/retrofit-workshop/labels/{name}")
  Response<Void> delete(@Path("name") String name);


}
