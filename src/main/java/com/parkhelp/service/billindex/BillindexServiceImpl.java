/**
 * @Description: TODO
 * @date 2017年6月20日 下午2:49:19 	
 */
package com.parkhelp.service.billindex;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.parkhelp.dao.billing.BillindexMapper;
import com.parkhelp.po.billing.Billindex;

/**
 * @author lzc
 *
 */
@Service
public class BillindexServiceImpl implements BillindexService{
	@Autowired
	private BillindexMapper billindexMapper;
	@Override
	public List<Billindex> findAll(Billindex billindex) {
		return billindexMapper.findAll(billindex);
	}
	@Override
	public Billindex findById(String id) {
		// TODO Auto-generated method stub
		return billindexMapper.findById(id);
	}
}
