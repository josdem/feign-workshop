package com.jos.dem.feign.workshop.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

import com.jos.dem.feign.workshop.model.SSHKey;
import com.jos.dem.feign.workshop.model.PublicEmail;

public interface UserService {

  @GET("users/josdem/keys")
  Call<List<SSHKey>> getKeys();

  @GET("user/public_emails")
  Call<List<PublicEmail>> getEmails();

}
