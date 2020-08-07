package io.antonpegov.jwt.controller;

import io.antonpegov.jwt.model.Topic;
import io.antonpegov.jwt.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

  @Autowired
  private TopicService topicService;

  @RequestMapping("/topics")
  public List<Topic> getAllTopics() {
    return topicService.getTopics();
  }

  @RequestMapping("/topics/{id}")
  public Topic getTopic(@PathVariable String id) {
    return topicService.getTopic(id);
  }
}
