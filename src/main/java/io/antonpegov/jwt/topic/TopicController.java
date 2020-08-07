package io.antonpegov.jwt.topic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

  @RequestMapping("/topics")
  public List<Topic> getAllTopics() {

    List<Topic> l = Arrays.asList(
      new Topic("spring", "Spring Framework", "Spring Framework Description"),
      new Topic("java", "Java Framework", "Core Java Description"),
      new Topic("javascript", "Spring Framework", "Spring Framework Description")
    );

    return l;
  }
}
