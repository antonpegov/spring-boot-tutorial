package io.antonpegov.jwt.controller;

import io.antonpegov.jwt.model.Topic;
import io.antonpegov.jwt.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

  @RequestMapping(method = RequestMethod.POST, value = "/topics")
  public void addTopic(@RequestBody Topic topic) {
    topicService.addTopic(topic);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
  public void updateTopic(@PathVariable String id, @RequestBody Topic topic) {
    topicService.updateTopic(id, topic);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
  public void deleteTopic(@PathVariable String id) {
    topicService.deleteTopic(id);
  }
}
