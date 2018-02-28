package com.parkhelp.service.system.parkinfo;
import java.util.List;
import com.parkhelp.po.system.parkinfo.PostInfo;

public interface PostInfoService {
	public List<PostInfo> findAll(PostInfo postInfo);

	public PostInfo findById(String id);

	public void delete(String id);

	public void update(PostInfo postInfo);

	public void add(PostInfo postInfo);
}
