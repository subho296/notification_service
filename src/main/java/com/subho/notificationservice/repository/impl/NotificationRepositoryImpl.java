package com.subho.notificationservice.repository.impl;

import com.subho.notificationservice.entities.Notification;
import com.subho.notificationservice.entities.Status;
import com.subho.notificationservice.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NotificationRepositoryImpl implements NotificationRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Notification save(Notification notification) {

        return mongoTemplate.save(notification);

    }

    @Override
    public Notification findById(String id) {
        return mongoTemplate.findById(id, Notification.class);
    }

    @Override
    public List<Notification> findByStatus(Status status) {
        Query query = new Query(Criteria.where("status").regex(status.toString()));
        return mongoTemplate.find(query, Notification.class);
    }

}
