package com.parkhelp.service.system.parkinfo;

import java.util.List;

import com.parkhelp.po.system.parkinfo.GateInfo;

public interface GateInfoService {
	 public List<GateInfo> findAll(GateInfo gateInfo);
	 public GateInfo findById(String id);
	 public void delete(String id);
	 public void update(GateInfo gateInfo);
	 public void add(GateInfo gateInfo);
}
