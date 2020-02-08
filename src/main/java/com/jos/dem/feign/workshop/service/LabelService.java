package com.jos.dem.feign.workshop.service;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Path;
import retrofit2.http.POST;
import retrofit2.http.PATCH;
import retrofit2.http.DELETE;

import com.jos.dem.feign.workshop.model.Label;
import com.jos.dem.feign.workshop.model.LabelResponse;

public interface LabelService {

  @POST("repos/josdem/retrofit-workshop/labels")
  Call<LabelResponse> create(@Body Label label);
  @PATCH("repos/josdem/retrofit-workshop/labels/{name}")
  Call<LabelResponse> update(@Body Label label, @Path("name") String name);
  @DELETE("repos/josdem/retrofit-workshop/labels/{name}")
  Call<Response<Void>> delete(@Path("name") String name);


}
