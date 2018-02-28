/**
 * @Description: TODO
 * @date 2017年6月20日 下午3:30:01 	
 */
package com.parkhelp.service.billindex;
import java.util.List;
import com.parkhelp.po.billing.ExtraBilling;
/**
 * @author lzc
 *
 */
public interface ExtraBillingService {
	public List<ExtraBilling> findAll(ExtraBilling ExtraBilling);
	public ExtraBilling findById(String id);
}	
