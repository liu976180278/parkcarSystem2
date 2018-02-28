package com.parkhelp.service.system;
import java.util.List;
import com.parkhelp.po.system.UserInfo;

public interface UserInfoService {
	public List<UserInfo> findAll(UserInfo userInfo);
	public UserInfo findById(String id);
	public void addUserInfo(UserInfo userInfo);
	public void delete(String id);
	public void update(UserInfo userInfo);
}
