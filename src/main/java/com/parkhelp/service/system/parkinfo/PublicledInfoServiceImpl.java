package com.parkhelp.service.system.parkinfo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkhelp.dao.system.parkinfo.PostInfoMapper;
import com.parkhelp.dao.system.parkinfo.PublicledInfoMapper;
import com.parkhelp.po.system.parkinfo.PublicledInfo;
@Service
public class PublicledInfoServiceImpl implements PublicledInfoService{
	@Autowired
	private PublicledInfoMapper publicledInfoMapper;
	public List<PublicledInfo> findAll(PublicledInfo publicledInfo) {
		return publicledInfoMapper.findAll(publicledInfo);
	}

	public PublicledInfo findById(String id) {
		return publicledInfoMapper.findById(id);
	}

	public void delete(String id) {
		publicledInfoMapper.delete(id);
	}

	public void update(PublicledInfo publicledInfo) {
		publicledInfoMapper.update(publicledInfo);
	}

	public void add(PublicledInfo publicledInfo) {
		publicledInfoMapper.add(publicledInfo);
	}
}
