package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.XiangcexinxiMapper;
import com.entity.Xiangcexinxi;
import com.server.XiangcexinxiServer;
@Service
public class XiangcexinxiServerImpi implements XiangcexinxiServer {
   @Resource
   private XiangcexinxiMapper gdao;
	@Override
	public int add(Xiangcexinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Xiangcexinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Xiangcexinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Xiangcexinxi> getsyxiangcexinxi1(Map<String, Object> map) {
		return gdao.getsyxiangcexinxi1(map);
	}
	public List<Xiangcexinxi> getsyxiangcexinxi2(Map<String, Object> map) {
		return gdao.getsyxiangcexinxi2(map);
	}
	public List<Xiangcexinxi> getsyxiangcexinxi3(Map<String, Object> map) {
		return gdao.getsyxiangcexinxi3(map);
	}
	
	@Override
	public Xiangcexinxi quchongXiangcexinxi(Map<String, Object> account) {
		return gdao.quchongXiangcexinxi(account);
	}

	@Override
	public List<Xiangcexinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Xiangcexinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Xiangcexinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

