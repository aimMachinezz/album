package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Xiangcexinxi;

public interface XiangcexinxiServer {

  public int add(Xiangcexinxi po);

  public int update(Xiangcexinxi po);
  
  
  
  public int delete(int id);

  public List<Xiangcexinxi> getAll(Map<String,Object> map);
  public List<Xiangcexinxi> getsyxiangcexinxi1(Map<String,Object> map);
  public List<Xiangcexinxi> getsyxiangcexinxi2(Map<String,Object> map);
  public List<Xiangcexinxi> getsyxiangcexinxi3(Map<String,Object> map);
  public Xiangcexinxi quchongXiangcexinxi(Map<String, Object> acount);

  public Xiangcexinxi getById( int id);

  public List<Xiangcexinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Xiangcexinxi> select(Map<String, Object> map);
}
//	所有List
