package com.springrest.liveasyassignment.services;

import com.springrest.liveasyassignment.dao.LoadDao;
import com.springrest.liveasyassignment.entities.Load;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class LoadServiceImpl implements LoadService {

  @Autowired
  private LoadDao loadDao;

  public LoadServiceImpl() {
  }

  public long generateLoadId() {
    return loadDao.count()+1;
  }

  @Override
  public List<Load> getAllLoads() {
    return loadDao.findAll();
  }

  @Override
  public void saveLoad(Load load) {
    load.setLoadId(generateLoadId());
    loadDao.save(load);
  }

  @Override
  public List<Load> getLoadByShipperId(String shipperId) {
    Long longShipperId = Long.parseLong(shipperId);
    return loadDao.findAllById(Collections.singletonList(longShipperId));
  }

  @Override
  public Load getLoadById(long loadId) {
    return loadDao.findById(loadId).orElse(null);
  }

  @Override
  public void updateLoad(long loadId, Load updatedLoad) {

  }

  @Override
  public void deleteLoad(long loadId) {

//    loadList.removeIf(load -> load.getLoadId().equals(loadId));
  }
}
