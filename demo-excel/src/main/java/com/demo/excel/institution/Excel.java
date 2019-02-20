package com.demo.excel.institution;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

public class Excel {

    private final static String PATH = System.getProperty("user.dir") ;

    public static void export(List<Map> list,String fileName) {

        //web对象
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建表头等
        HSSFSheet sheet = wb.createSheet("机构活动打卡数据");

        createHeader(sheet);

        for (int i = 1 ;i < list.size() + 1 ;i ++) {
            Map m = list.get(i - 1);
            String column1 = String.valueOf(m.get(1));
            String column2 = String.valueOf(m.get(2));
            String column3 = String.valueOf(m.get(3));

            //创建行
            HSSFRow row = sheet.createRow(i);

            //创建列
            HSSFCell cell = row.createCell(0);
            cell.setCellValue(column1);
            sheet.addMergedRegion(new CellRangeAddress(i,i,0,0));


            HSSFCell cell2 = row.createCell(1);
            cell2.setCellValue(column2);
            sheet.addMergedRegion(new CellRangeAddress(i,i,1,1));


            HSSFCell cell3 = row.createCell(2);
            cell3.setCellValue(Integer.valueOf(column3));
            sheet.addMergedRegion(new CellRangeAddress(i,i,2,2));
        }

        try {
            FileOutputStream output = new FileOutputStream(PATH + File.separator + fileName);
            wb.write(output);
            output.flush();
            System.out.println("成功创建excel文件,在" + PATH);
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private static void createHeader(HSSFSheet sheet) {
        //创建行
        HSSFRow row = sheet.createRow(0);

        //创建列
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("机构名称");

        HSSFCell cell2 = row.createCell(1);
        cell2.setCellValue("活动名称");

        HSSFCell cell3 = row.createCell(2);
        cell3.setCellValue("打卡数");
    }
}
