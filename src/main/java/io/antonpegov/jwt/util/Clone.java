package io.antonpegov.jwt.util;

import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;

@Service
public class Clone {

  public final Object deep(Object source) {
    return SerializationUtils.deserialize(SerializationUtils.serialize(source));
  }

  public final Object shallow(Object source) {
    return new Object();
  }
}
