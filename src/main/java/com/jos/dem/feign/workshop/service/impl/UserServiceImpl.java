package com.jos.dem.feign.workshop.service.impl;

import com.jos.dem.feign.workshop.service.UserService;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.jos.dem.feign.workshop.model.SSHKey;
import com.jos.dem.feign.workshop.model.PublicEmail;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private Retrofit retrofit;

  private UserService userService;

  @PostConstruct
  public void setup() {
    userService = retrofit.create(UserService.class);
  }

  public Call<List<SSHKey>> getKeys() {
    return userService.getKeys();
  }

  public Call<List<PublicEmail>> getEmails() {
    return userService.getEmails();
  }

}
