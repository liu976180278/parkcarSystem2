package com.parkhelp.dao.system;
import java.util.List;
import com.parkhelp.po.system.UserInfo;
public interface UserInfoMapper {
	public List<UserInfo> findAll(UserInfo userInfo);
	public UserInfo findById(String id);
	public void addUserInfo(UserInfo userInfo);
	public void delete(String id);
	public void update(UserInfo userInfo);
}
