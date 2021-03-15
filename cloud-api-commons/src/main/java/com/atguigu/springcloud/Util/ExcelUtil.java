package com.atguigu.springcloud.Util;


import org.apache.poi.hssf.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @ClassName ExcelUtil
 * @Description: 描述
 * @Author hc
 * @Date 2020/5/13 19:09
 * @Version V1.0
 **/
public class ExcelUtil {

    public static void exportExcel(HttpServletResponse response, com.xiye.common.util.ExcelData data){
        com.xiye.common.util.LoggerUtil.info("excel导出开始...");
        try {
            //实例化HSSFWorkbook,创建Excel工作簿对象
            HSSFWorkbook workbook = new HSSFWorkbook();
            //创建一个Excel表单，参数为sheet的名字
            HSSFSheet sheet = workbook.createSheet("sheet");
            //设置表头
            setTitle(workbook, sheet, data.getHead());
            //设置单元格并赋值
            setData(sheet, data.getData());
            //设置浏览器下载
            setBrowser(response, workbook, data.getFileName());
            com.xiye.common.util.LoggerUtil.info("导出成功!");
        } catch (Exception e) {
            com.xiye.common.util.LoggerUtil.info("导出失败!");
            e.printStackTrace();
        }
    }
    private static void setTitle(HSSFWorkbook workbook, HSSFSheet sheet, String[] str) {
        try {
            HSSFRow row = sheet.createRow(0);
            //设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度
            for (int i = 0; i <= str.length; i++) {
                sheet.setColumnWidth(i, 15 * 256);
            }
            //设置为居中加粗,格式化时间格式
            HSSFCellStyle style = workbook.createCellStyle();
            HSSFFont font = workbook.createFont();
            font.setBold(true);
            style.setFont(font);
            style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
            //创建表头名称
            HSSFCell cell;
            for (int j = 0; j < str.length; j++) {
                cell = row.createCell(j);
                cell.setCellValue(str[j]);
                cell.setCellStyle(style);
            }
        } catch (Exception e) {
            com.xiye.common.util.LoggerUtil.info("导出时设置表头失败！");
            e.printStackTrace();
        }
    }

    private static void setData(HSSFSheet sheet, List<String[]> data) {
        try{
            int rowNum = 1;
            for (int i = 0; i < data.size(); i++) {
                HSSFRow row = sheet.createRow(rowNum);
                for (int j = 0; j < data.get(i).length; j++) {
                    row.createCell(j).setCellValue(data.get(i)[j]);
                }
                rowNum++;
            }
            com.xiye.common.util.LoggerUtil.info("表格赋值成功！");
        }catch (Exception e){
            com.xiye.common.util.LoggerUtil.info("表格赋值失败！");
            e.printStackTrace();
        }
    }

    private static void setBrowser(HttpServletResponse response, HSSFWorkbook workbook, String fileName) {
        try {
            //清空response
            response.reset();
            //设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
            OutputStream os = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/vnd.ms-excel;charset=gb2312");
            //将excel写入到输出流中
            workbook.write(os);
            os.flush();
            os.close();
            com.xiye.common.util.LoggerUtil.info("设置浏览器下载成功！");
        } catch (Exception e) {
            com.xiye.common.util.LoggerUtil.info("设置浏览器下载失败！");
            e.printStackTrace();
        }

    }




}
