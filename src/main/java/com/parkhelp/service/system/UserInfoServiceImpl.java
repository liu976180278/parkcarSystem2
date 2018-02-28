package com.parkhelp.service.system;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.parkhelp.dao.system.UserInfoMapper;
import com.parkhelp.po.system.UserInfo;
@Service
public class UserInfoServiceImpl implements UserInfoService{
	@Autowired
	private UserInfoMapper userInfoMapper;
	public List<UserInfo> findAll(UserInfo userInfo) {
		return userInfoMapper.findAll(userInfo);
	}

	public UserInfo findById(String id) {
		return userInfoMapper.findById(id);
	}

	public void addUserInfo(UserInfo userInfo) {
		userInfoMapper.addUserInfo(userInfo);
	}

	public void delete(String id) {
		userInfoMapper.delete(id);
	}

	public void update(UserInfo userInfo) {
		userInfoMapper.update(userInfo);
	}

}
