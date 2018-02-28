package com.parkhelp.service.system;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import org.springframework.stereotype.Component;
import com.parkhelp.po.system.MemberCar;
public interface MemberService{
	public List<MemberCar> findAll(MemberCar memberCar);
	public void update(MemberCar memberCar);
	public MemberCar findMemberCarById(String id);
	public void delete(String id);
	public void addMemberCar(MemberCar memberCar);
	public List<MemberCar> importMember(File file);
	public  void exportMemberCar(File file, List<MemberCar> memberCars) throws FileNotFoundException; 
}
