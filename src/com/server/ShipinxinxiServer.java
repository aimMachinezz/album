package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Shipinxinxi;

public interface ShipinxinxiServer {

  public int add(Shipinxinxi po);

  public int update(Shipinxinxi po);
  
  
  
  public int delete(int id);

  public List<Shipinxinxi> getAll(Map<String,Object> map);
  public List<Shipinxinxi> getsyshipinxinxi1(Map<String,Object> map);
  public List<Shipinxinxi> getsyshipinxinxi2(Map<String,Object> map);
  public List<Shipinxinxi> getsyshipinxinxi3(Map<String,Object> map);
  public Shipinxinxi quchongShipinxinxi(Map<String, Object> acount);

  public Shipinxinxi getById( int id);

  public List<Shipinxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Shipinxinxi> select(Map<String, Object> map);
}
//	所有List
