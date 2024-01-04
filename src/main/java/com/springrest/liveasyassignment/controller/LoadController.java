package com.springrest.liveasyassignment.controller;

import com.springrest.liveasyassignment.entities.Load;
import com.springrest.liveasyassignment.services.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/load")
public class LoadController {

  private final LoadService loadService;

  @Autowired
  public LoadController(LoadService loadService){
    this.loadService = loadService;
  }

  @PostMapping
  public String addLoad(@RequestBody Load load){
//    load.setLoadId();
    loadService.saveLoad(load);
    return "load details added successfully!";
  }

  @GetMapping("/all")
  public  List<Load> getAllLoads(){
    return loadService.getAllLoads();
  }
  @GetMapping
  public List<Load> getLoadsByShipperId(@RequestParam String shipperId){

    return loadService.getLoadByShipperId(shipperId);
  }

  @GetMapping("/{loadId}")
  public Load getLoadById(@PathVariable long loadId){
    return loadService.getLoadById(loadId);
  }

  @PutMapping("/{loadId}")
  public void updateLoad(@PathVariable long loadId, @RequestBody Load updatedLoad) {
    loadService.updateLoad(loadId, updatedLoad);
  }

  @DeleteMapping("/{loadId}")
  public void deleteLoad(@PathVariable long loadId) {
    loadService.deleteLoad(loadId);
  }
}
