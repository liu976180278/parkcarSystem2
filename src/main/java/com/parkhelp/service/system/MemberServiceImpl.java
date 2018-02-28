package com.parkhelp.service.system;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkhelp.dao.system.MemberCarMapper;
import com.parkhelp.po.system.MemberCar;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberCarMapper memberCarMapper;

	public List<MemberCar> findAll(MemberCar memberCar) {
		return memberCarMapper.findAll(memberCar);
	}

	public void update(MemberCar memberCar) {
		memberCarMapper.update(memberCar);
	}

	public MemberCar findMemberCarById(String id) {
		return memberCarMapper.findMemberCarById(id);
	}

	public void delete(String id) {
		memberCarMapper.delete(id);
	}

	public void addMemberCar(MemberCar memberCar) {
		memberCarMapper.addMemberCar(memberCar);
	}

	/**
	 * 导入会员。
	 * 
	 * @param file
	 *            导入的文件。
	 * @return 成功导入的用户个数。
	 */
	public List<MemberCar> importMember(File file) {
		List<MemberCar> memberCars = new ArrayList<MemberCar>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日/HH:mm");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Workbook wb = null;
		try {
			wb = new HSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		try {
			Sheet sheet = wb.getSheetAt(0);
			if (sheet.getPhysicalNumberOfRows() > 2) {
				for (int k = 2; k < sheet.getPhysicalNumberOfRows(); k++) {
					Row row = sheet.getRow(k);
					MemberCar member = new MemberCar();
					String carno = row.getCell(0).getStringCellValue();
					member.setCarno(carno);

					String carnocolor = row.getCell(1).getStringCellValue();
					member.setCarnocolor(carnocolor);

					row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
					Double balance = Double.parseDouble(row.getCell(2)
							.getStringCellValue());
					member.setBalance(balance);

					Date starttime = sdf.parse(row.getCell(3)
							.getStringCellValue());
					member.setStarttime(starttime);

					Date endtime = sdf.parse(row.getCell(4)
							.getStringCellValue());
					member.setEndtime(endtime);

					row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
					String cartype = row.getCell(5).getStringCellValue();
					member.setCartype(cartype);

					String zone_id = row.getCell(6).getStringCellValue();
					member.setZone_id(zone_id);

					String carowner = row.getCell(7).getStringCellValue();
					member.setCarowner(carowner);

					row.getCell(8).setCellType(Cell.CELL_TYPE_STRING);
					String telno = row.getCell(8).getStringCellValue();
					member.setTelno(telno);

					memberCars.add(member);
					List<MemberCar> list = memberCarMapper.findByCarno(carno);
					if (list.size() == 0) {
						memberCarMapper.addMemberCar(member);
					}
					fis.close();
				}
			}
		} catch (NullPointerException e) {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberCars;
	}

	/**
	 * 导出会员。
	 * 
	 * @param file
	 *            导出的文件
	 * @param memberCars
	 *            要导出的<code>MemberCar</code>对象。
	 * @throws FileNotFoundException
	 * @see memberCars
	 */
	public void exportMemberCar(File file, List<MemberCar> memberCars)
			throws FileNotFoundException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat sdfex = new SimpleDateFormat("yyyy年MM月dd日/HH:mm");
		try {

			if (file != null && memberCars.size() > 0) {
				Workbook wb = new HSSFWorkbook();
				FileOutputStream fileOut;
				// 1.1列表样式
				CellStyle style1 = creatCellStyle(wb, (short) 13);
				CellStyle style2 = creatCellStyle(wb, (short) 16);
				fileOut = new FileOutputStream(file);
				Sheet sheet = wb.createSheet("会员管理");
				// 标题 ，//第一行
				CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 0,
						0, 8);
				sheet.addMergedRegion(cellRangeAddress);
				sheet.setDefaultColumnWidth(20);
				Row row0 = sheet.createRow(0);
				Cell cell = row0.createCell(0);
				// 加载单元格样式
				cell.setCellStyle(style2);
				cell.setCellValue("会员列表");
				// 标题行，第二行
				Row row1 = sheet.createRow(1);
				String[] titles = { "车主号码", "车牌颜色", "账户余额", "有效开始时间", "有效结束时间",
						"车辆类型", "所在区域", "车主姓名", "车主电话" };
				for (int i = 0; i < titles.length; i++) {
					Cell cell1 = row1.createCell(i);
					cell1.setCellStyle(style1);
					cell1.setCellValue(titles[i]);
				}
				for (int i = 0; i < memberCars.size(); i++) {
					Row row = sheet.createRow(i + 2);
					row.createCell(0)
							.setCellValue(memberCars.get(i).getCarno());
					row.createCell(1).setCellValue(
							memberCars.get(i).getCarnocolor());

					if (memberCars.get(i).getBalance() != null) {
						row.createCell(2).setCellValue(
								memberCars.get(i).getBalance());
					} else {
						row.createCell(2).setCellValue("0");
					}

					Date dstart = sdf
							.parse(memberCars.get(i).getStrstarttime());
					row.createCell(3).setCellValue(sdfex.format(dstart));
					Date dend = sdf.parse(memberCars.get(i).getStrendtime());
					row.createCell(4).setCellValue(sdfex.format(dend));

					row.createCell(5).setCellValue(
							memberCars.get(i).getCartype());
					row.createCell(6).setCellValue(
							memberCars.get(i).getZone_id());
					row.createCell(7).setCellValue(
							memberCars.get(i).getCarowner());
					row.createCell(8)
							.setCellValue(memberCars.get(i).getTelno());

				}
				wb.write(fileOut);
				fileOut.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	// 创建单元格样式
	public CellStyle creatCellStyle(Workbook workbook, short fontSize) {
		CellStyle style = workbook.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);// 水平居中
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);// 垂直居中
		// 颜色
		style.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		// 1.2.1 创建字体
		Font font = workbook.createFont();
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);// 字体加粗
		font.setFontHeightInPoints((short) fontSize);
		// 加载字体
		style.setFont(font);
		return style;
	}

}
