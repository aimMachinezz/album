package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Shipinxinxi;

public interface ShipinxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shipinxinxi record);

    int insertSelective(Shipinxinxi record);

    Shipinxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shipinxinxi record);
	
    int updateByPrimaryKey(Shipinxinxi record);
	public Shipinxinxi quchongShipinxinxi(Map<String, Object> faburen);
	public List<Shipinxinxi> getAll(Map<String, Object> map);
	public List<Shipinxinxi> getsyshipinxinxi1(Map<String, Object> map);
	public List<Shipinxinxi> getsyshipinxinxi3(Map<String, Object> map);
	public List<Shipinxinxi> getsyshipinxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shipinxinxi> getByPage(Map<String, Object> map);
	public List<Shipinxinxi> select(Map<String, Object> map);
//	所有List
}

