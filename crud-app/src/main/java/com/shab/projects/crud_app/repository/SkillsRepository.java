package com.shab.projects.crud_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shab.projects.crud_app.entity.SkillsEntity;

@Repository
public interface SkillsRepository extends JpaRepository<SkillsEntity, Integer> {
}
