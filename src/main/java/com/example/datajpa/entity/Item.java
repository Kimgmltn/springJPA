package com.example.datajpa.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@EntityListeners(value = AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item implements Persistable<String> {

    public Item(String id) {
        this.id = id;
    }

    @Id
    private String id;
    @CreatedDate
    private LocalDateTime createdDate;


    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        // 로직 직접 짜야함
        return createdDate == null;
    }


}
