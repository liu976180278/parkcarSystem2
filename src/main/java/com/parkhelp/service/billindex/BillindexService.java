/**
 * @Description: TODO
 * @date 2017年6月20日 下午2:48:06 	
 */
package com.parkhelp.service.billindex;
import java.util.List;
import com.parkhelp.po.billing.Billindex;

/**
 * @author lzc
 *
 */
public interface BillindexService {
	public List<Billindex> findAll(Billindex billindex);
	public Billindex findById(String id);
}
