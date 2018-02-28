package com.parkhelp.dao.system;
import java.util.List;

import com.parkhelp.po.system.MemberCar;
public interface MemberCarMapper {
	public List<MemberCar> findAll(MemberCar memberCar);
	public List<MemberCar> findByCarno(String Carno);
	public void update(MemberCar memberCar);
	public MemberCar findMemberCarById(String id);
	public void delete(String id);
	public void addMemberCar(MemberCar memberCar);
}
