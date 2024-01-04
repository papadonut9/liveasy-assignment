package com.springrest.liveasyassignment.services;

import com.springrest.liveasyassignment.entities.Load;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoadServiceImpl implements LoadService {

  List<Load> loadList;

  public LoadServiceImpl() {
    loadList = new ArrayList<>();
    loadList.add(new Load(generateLoadId(), "Mumbai", "Bengaluru", "chemicals", "canter", 1, 250, "", "s01", "31-12-2023"
    ));
    loadList.add(new Load(generateLoadId(), "Delhi", "Gurugram", "Food", "canter", 1, 1000, "", "s02", "14-11-2023"
    ));
  }

  public String generateLoadId() {
    return "load" + loadList.size();
  }
  /*@Override
  public List<Load> getLoadByShipperId(String shipperId) {
    List<Load> res = new ArrayList<>();
    for(Load load : loadList){
      if(load.getShipperId().equals(shipperId))
        res.add(load);
    }
  }*/

  @Override
  public List<Load> getAllLoads() {
    return loadList;
  }

  @Override
  public void saveLoad(Load load) {

    load.setLoadId(generateLoadId());
    loadList.add(load);
  }

  @Override
  public List<Load> getLoadByShipperId(String shipperId) {
    List<Load> res = new ArrayList<>();
    for (Load load : loadList) {
      if (load.getShipperId().equals(shipperId))
        res.add(load);
    }
    return res;
  }

  @Override
  public Load getLoadById(String loadId) {
    for(Load load: loadList){
      if(load.getLoadId().equals(loadId))
        return load;
    }
    return null;
  }

  @Override
  public void updateLoad(String loadId, Load updatedLoad) {
    for(int i = 0; i < loadList.size(); i++){
      Load load = loadList.get(i);
      if(load.getLoadId().equals(loadId)){
        updatedLoad.setLoadId(loadId);
        loadList.set(i, updatedLoad);
        break;
      }
    }
  }

  @Override
  public void deleteLoad(String loadId) {
    loadList.removeIf(load -> load.getLoadId().equals(loadId));
  }
}
