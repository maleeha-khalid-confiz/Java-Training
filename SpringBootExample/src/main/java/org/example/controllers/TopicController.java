package org.example.controllers;

import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.example.dtos.TopicDto;
import org.example.entities.Topic;
import org.example.services.TopicService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CommonsLog
public class TopicController {

//    Logger logger = LoggerFactory.getLogger(TopicController.class);

    @Autowired
    private TopicService topicService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping("/topics")
    public List<TopicDto> getAllTopics(){
//        Map<String, String> map = topicService.getDbConnection();
//        for (Map.Entry<String, String> item : map.entrySet()) {
//            String key = item.getKey();
//            String value = item.getValue();
//            logger.info( value);
//        }
        log.info(topicService.getMessage());
        List<Topic> topics = topicService.getAllTopics();
        return topics.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @RequestMapping("/topics/{id}")
    public TopicDto getTopic(@PathVariable int id){
        Topic topic = topicService.getTopic(id);
        return convertToDto(topic);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@Valid @RequestBody TopicDto topicDto){
        Topic topic =  convertToEntity(topicDto);
        topicService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics")
    public void updateTopic(@RequestBody TopicDto topicDto){
        Topic topic =  convertToEntity(topicDto);
        topicService.updateTopic(topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopic(@PathVariable int id){
        topicService.deleteTopic(id);
    }


    private TopicDto convertToDto(Topic topic){
        return modelMapper.map(topic, TopicDto.class);
    }
    private Topic convertToEntity(TopicDto topicDto){
        return modelMapper.map(topicDto, Topic.class);
    }
}
