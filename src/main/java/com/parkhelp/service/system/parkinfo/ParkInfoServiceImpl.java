package com.parkhelp.service.system.parkinfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkhelp.dao.system.parkinfo.GateInfoMapper;
import com.parkhelp.dao.system.parkinfo.ParkInfoMapper;
import com.parkhelp.po.system.parkinfo.GateInfo;
import com.parkhelp.po.system.parkinfo.ParkInfo;
@Service
public class ParkInfoServiceImpl  implements ParkInfoService{
	@Autowired
	private ParkInfoMapper parkInfoCarMapper;
	public List<ParkInfo> findAll(ParkInfo parkInfo) {
		return parkInfoCarMapper.findAll(parkInfo);
	}

	public ParkInfo findById(String id) {
		return parkInfoCarMapper.findById(id);
	}

	public void delete(String id) {
		parkInfoCarMapper.delete(id);
	}

	public void update(ParkInfo parkInfo) {
		parkInfoCarMapper.update(parkInfo);
	}

	public void add(ParkInfo parkInfo) {
		parkInfoCarMapper.add(parkInfo);
	}
}
