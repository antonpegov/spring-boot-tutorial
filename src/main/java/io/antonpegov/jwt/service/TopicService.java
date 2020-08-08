package io.antonpegov.jwt.service;

import io.antonpegov.jwt.model.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    private final List<Topic> topics = new ArrayList<>(List.of(
      new Topic("spring", "Spring Framework", "Spring Framework Description"),
      new Topic("java", "Java Framework", "Core Java Description"),
      new Topic("javascript", "Spring Framework", "Spring Framework Description")
    ));

    private Topic getTopicById (String id) {
      return topics.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Topic> getTopics() {
      return topics;
    }

    public Topic getTopic(String id) {
      return getTopicById(id);
    }

    public void addTopic(Topic topic) {
      if (getTopicById(topic.getId()) == null) {
          topics.add(topic);
      }
    }

    public void updateTopic(String id, Topic topic) {
      topics.remove(getTopicById(id));
      topics.add(topic);
    }

    public void deleteTopic(String id) {
        topics.remove(getTopicById(id));
    }
}
