package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ShipinxinxiMapper;
import com.entity.Shipinxinxi;
import com.server.ShipinxinxiServer;
@Service
public class ShipinxinxiServerImpi implements ShipinxinxiServer {
   @Resource
   private ShipinxinxiMapper gdao;
	@Override
	public int add(Shipinxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shipinxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shipinxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Shipinxinxi> getsyshipinxinxi1(Map<String, Object> map) {
		return gdao.getsyshipinxinxi1(map);
	}
	public List<Shipinxinxi> getsyshipinxinxi2(Map<String, Object> map) {
		return gdao.getsyshipinxinxi2(map);
	}
	public List<Shipinxinxi> getsyshipinxinxi3(Map<String, Object> map) {
		return gdao.getsyshipinxinxi3(map);
	}
	
	@Override
	public Shipinxinxi quchongShipinxinxi(Map<String, Object> account) {
		return gdao.quchongShipinxinxi(account);
	}

	@Override
	public List<Shipinxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shipinxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shipinxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

