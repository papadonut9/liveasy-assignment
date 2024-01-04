package com.springrest.liveasyassignment.services;

import com.springrest.liveasyassignment.entities.Load;

import java.util.List;

public interface LoadService {
  void saveLoad(Load load);

  List<Load> getAllLoads();
  List<Load> getLoadByShipperId(String shipperId);

  Load getLoadById(String loadId);

  void updateLoad(String loadId, Load updatedLoad);

  void deleteLoad(String loadId);
}
