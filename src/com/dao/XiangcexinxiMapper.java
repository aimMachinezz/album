package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Xiangcexinxi;

public interface XiangcexinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Xiangcexinxi record);

    int insertSelective(Xiangcexinxi record);

    Xiangcexinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Xiangcexinxi record);
	
    int updateByPrimaryKey(Xiangcexinxi record);
	public Xiangcexinxi quchongXiangcexinxi(Map<String, Object> faburen);
	public List<Xiangcexinxi> getAll(Map<String, Object> map);
	public List<Xiangcexinxi> getsyxiangcexinxi1(Map<String, Object> map);
	public List<Xiangcexinxi> getsyxiangcexinxi3(Map<String, Object> map);
	public List<Xiangcexinxi> getsyxiangcexinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Xiangcexinxi> getByPage(Map<String, Object> map);
	public List<Xiangcexinxi> select(Map<String, Object> map);
//	所有List
}

