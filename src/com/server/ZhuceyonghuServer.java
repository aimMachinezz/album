package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Zhuceyonghu;

public interface ZhuceyonghuServer {

  public int add(Zhuceyonghu po);

  public int update(Zhuceyonghu po);
  
  
  
  public int delete(int id);

  public List<Zhuceyonghu> getAll(Map<String,Object> map);
  public List<Zhuceyonghu> getsyzhuceyonghu1(Map<String,Object> map);
  public List<Zhuceyonghu> getsyzhuceyonghu2(Map<String,Object> map);
  public List<Zhuceyonghu> getsyzhuceyonghu3(Map<String,Object> map);
  public Zhuceyonghu quchongZhuceyonghu(Map<String, Object> acount);

  public Zhuceyonghu getById( int id);

  public List<Zhuceyonghu> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Zhuceyonghu> select(Map<String, Object> map);
}
//	所有List
