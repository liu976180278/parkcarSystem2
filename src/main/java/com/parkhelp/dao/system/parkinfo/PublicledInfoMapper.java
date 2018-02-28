package com.parkhelp.dao.system.parkinfo;
import java.util.List;
import com.parkhelp.po.system.parkinfo.PublicledInfo;

public interface PublicledInfoMapper {
	public List<PublicledInfo> findAll(PublicledInfo publicledInfo);
	public PublicledInfo findById(String id);
	public void delete(String id);
	public void update(PublicledInfo publicledInfo);
	public void add(PublicledInfo publicledInfo);
}
