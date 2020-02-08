package com.jos.dem.feign.workshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SSHKey {
  Long id;
  String key;
}
