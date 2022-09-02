package org.example.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Course {

    @Id
    private int id;
    private String name;
    @ManyToOne
    private Topic topic;



    public Course(){

    }

    public Course(int id, String name, int  topicId){
        this.id = id;
        this.name = name;
        this.topic= new Topic(topicId, "");
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

}
