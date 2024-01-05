package com.springrest.liveasyassignment.dao;

import com.springrest.liveasyassignment.entities.Load;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoadDao extends JpaRepository<Load, Long> {
  List<Load> findByShipperId(String shipperId);
}
