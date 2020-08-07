package io.antonpegov.jwt.service;

import io.antonpegov.jwt.model.Topic;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    private List<Topic> topics = Arrays.asList(
      new Topic("spring", "Spring Framework", "Spring Framework Description"),
      new Topic("java", "Java Framework", "Core Java Description"),
      new Topic("javascript", "Spring Framework", "Spring Framework Description")
    );

    public List<Topic> getTopics() {
        return topics;
    }
}
