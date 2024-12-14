package com.shab.projects.crud_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shab.projects.crud_app.entity.ContactEntity;

public interface ContactInfoRepository extends JpaRepository<ContactEntity, Integer>{

}
