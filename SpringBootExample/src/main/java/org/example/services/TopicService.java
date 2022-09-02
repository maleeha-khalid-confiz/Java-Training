package org.example.services;

import org.example.data.TopicRepository;
import org.example.entities.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Value("${env}")
    private String message;



    @Value("#{${db-configuration}}")
    private Map<String, String> dbConnection;

    public List<Topic> getAllTopics(){
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return  topics;
    }

    public Topic getTopic(int id){
        return topicRepository.findById(id).get();
    }

    public void addTopic(Topic topic){
         topicRepository.save(topic);
    }

    public void updateTopic(Topic topic){
        topicRepository.save(topic);
    }

    public void deleteTopic(int id){
        topicRepository.deleteById(id);
    }
    public String getMessage() {
        return message;
    }
    public Map<String, String> getDbConnection() {
        return dbConnection;
    }
}
