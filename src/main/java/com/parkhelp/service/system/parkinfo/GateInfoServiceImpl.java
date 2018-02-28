package com.parkhelp.service.system.parkinfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.parkhelp.dao.system.parkinfo.GateInfoMapper;
import com.parkhelp.po.system.parkinfo.GateInfo;
@Service
public class GateInfoServiceImpl implements  GateInfoService{
	@Autowired
	private GateInfoMapper gateInfoCarMapper;
	public List<GateInfo> findAll(GateInfo gateInfo) {
		return gateInfoCarMapper.findAll(gateInfo);
	}

	public GateInfo findById(String id) {
		return gateInfoCarMapper.findById(id);
	}

	public void delete(String id) {
		gateInfoCarMapper.delete(id);
	}

	public void update(GateInfo gateInfo) {
		gateInfoCarMapper.update(gateInfo);
	}

	public void add(GateInfo gateInfo) {
		gateInfoCarMapper.add(gateInfo);
	}
}
