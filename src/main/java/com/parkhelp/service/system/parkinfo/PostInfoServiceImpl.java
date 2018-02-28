package com.parkhelp.service.system.parkinfo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkhelp.dao.system.parkinfo.ParkZoneInfoMapper;
import com.parkhelp.dao.system.parkinfo.PostInfoMapper;
import com.parkhelp.po.system.parkinfo.PostInfo;
@Service
public class PostInfoServiceImpl implements PostInfoService{
	@Autowired
	private PostInfoMapper postInfoMapper;
	public List<PostInfo> findAll(PostInfo postInfo) {
		return postInfoMapper.findAll(postInfo);
	}

	public PostInfo findById(String id) {
		return postInfoMapper.findById(id);
	}

	public void delete(String id) {
		postInfoMapper.delete(id);
	}

	public void update(PostInfo postInfo) {
		postInfoMapper.update(postInfo);
	}

	public void add(PostInfo postInfo) {
		postInfoMapper.add(postInfo);
	}
}
