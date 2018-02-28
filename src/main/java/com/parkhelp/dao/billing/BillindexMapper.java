/**
 * @Description: TODO
 * @date 2017年6月19日 上午10:08:00 	
 */
package com.parkhelp.dao.billing;

import java.util.List;

import com.parkhelp.po.billing.Billindex;

/**
 * @author lzc
 *
 */
public interface BillindexMapper {
	public List<Billindex> findAll(Billindex billindex);
	public Billindex findById(String id);
}
