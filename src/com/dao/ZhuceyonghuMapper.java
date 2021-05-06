package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Zhuceyonghu;

public interface ZhuceyonghuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Zhuceyonghu record);

    int insertSelective(Zhuceyonghu record);

    Zhuceyonghu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Zhuceyonghu record);
	
    int updateByPrimaryKey(Zhuceyonghu record);
	public Zhuceyonghu quchongZhuceyonghu(Map<String, Object> yonghuming);
	public List<Zhuceyonghu> getAll(Map<String, Object> map);
	public List<Zhuceyonghu> getsyzhuceyonghu1(Map<String, Object> map);
	public List<Zhuceyonghu> getsyzhuceyonghu3(Map<String, Object> map);
	public List<Zhuceyonghu> getsyzhuceyonghu2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Zhuceyonghu> getByPage(Map<String, Object> map);
	public List<Zhuceyonghu> select(Map<String, Object> map);
//	所有List
}

