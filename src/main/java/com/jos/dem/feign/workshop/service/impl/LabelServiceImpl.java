package com.jos.dem.feign.workshop.service.impl;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.Path;


import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.jos.dem.feign.workshop.model.Label;
import com.jos.dem.feign.workshop.model.LabelResponse;
import com.jos.dem.feign.workshop.service.LabelService;

@Service
public class LabelServiceImpl implements LabelService {

  @Autowired
  private Retrofit retrofit;

  private LabelService labelService;

  @PostConstruct
  public void setup() {
    labelService = retrofit.create(LabelService.class);
  }

  public Call<LabelResponse> create(@Body Label label) {
    return labelService.create(label);
  }

  public Call<LabelResponse> update(@Body Label label, @Path("name") String name) {
    return labelService.update(label, name);
  }

  public Call<Response<Void>> delete(@Path("name") String name) {
    return labelService.delete(name);
  }

}
