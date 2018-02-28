/**
 * @Description: TODO
 * @date 2017年6月20日 下午3:06:19 	
 */
package com.parkhelp.dao.billing;
import java.util.List;
import com.parkhelp.po.billing.ExtraBilling;

/**
 * @author lzc
 *
 */
public interface ExtraBillingMapper {
	public List<ExtraBilling> findAll(ExtraBilling ExtraBilling);
	public ExtraBilling findById(String id);
}
