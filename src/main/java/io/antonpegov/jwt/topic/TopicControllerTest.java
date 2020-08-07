package io.antonpegov.jwt.topic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicControllerTest {

  @RequestMapping("/topics-test")
  public String getAllTopics() {
    return "All Topics Test";
  }
}
