/**
 * @Description: TODO
 * @date 2017年6月20日 下午3:30:34 	
 */
package com.parkhelp.service.billindex;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.parkhelp.dao.billing.ExtraBillingMapper;
import com.parkhelp.po.billing.ExtraBilling;

/**
 * @author lzc
 *
 */
@Service
public class ExtraBillingServiceImpl implements ExtraBillingService {
	@Autowired
	private ExtraBillingMapper extraBillingMapper;
	@Override
	public List<ExtraBilling> findAll(ExtraBilling ExtraBilling) {
		return extraBillingMapper.findAll(ExtraBilling);
	}

	@Override
	public ExtraBilling findById(String id) {
		return extraBillingMapper.findById(id);
	}

}
