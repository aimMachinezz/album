package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ZhuceyonghuMapper;
import com.entity.Zhuceyonghu;
import com.server.ZhuceyonghuServer;
@Service
public class ZhuceyonghuServerImpi implements ZhuceyonghuServer {
   @Resource
   private ZhuceyonghuMapper gdao;
	@Override
	public int add(Zhuceyonghu po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Zhuceyonghu po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Zhuceyonghu> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Zhuceyonghu> getsyzhuceyonghu1(Map<String, Object> map) {
		return gdao.getsyzhuceyonghu1(map);
	}
	public List<Zhuceyonghu> getsyzhuceyonghu2(Map<String, Object> map) {
		return gdao.getsyzhuceyonghu2(map);
	}
	public List<Zhuceyonghu> getsyzhuceyonghu3(Map<String, Object> map) {
		return gdao.getsyzhuceyonghu3(map);
	}
	
	@Override
	public Zhuceyonghu quchongZhuceyonghu(Map<String, Object> account) {
		return gdao.quchongZhuceyonghu(account);
	}

	@Override
	public List<Zhuceyonghu> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Zhuceyonghu> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Zhuceyonghu getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

