package com.psych.psychGame.repositories;

import com.psych.psychGame.model.ContentWriter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentWriterRepository extends JpaRepository<ContentWriter, Long> {
}
