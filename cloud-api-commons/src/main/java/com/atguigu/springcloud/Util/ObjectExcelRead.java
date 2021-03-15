package com.atguigu.springcloud.Util;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hc
 * @version V1.0
 * @title FileDownload.java
 * @package com.xiye.common.util
 * @description 从EXCEL导入到数据库
 * @date 2019-05-11
 */
public final class ObjectExcelRead {

    private ObjectExcelRead() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * @Author hc
     * @Date 2019-05-11 16:26:11
     * @Description 从EXCEL导入到数据库
     * @Param [filepath, filename, startrow, startcol, sheetnum] filepath 文件路径;filename 文件名;startrow 开始行号;startcol 开始列号;sheetnum sheet
     * @Return java.util.List<java.lang.Object>
     */
    public static List<Object> readExcel(FileInputStream fi, int startrow, int startcol, int sheetnum) {
        List<Object> varList = new ArrayList<>();

        try {
            XSSFWorkbook wb = new XSSFWorkbook(fi);
            /* sheet 从0开始 */
            XSSFSheet sheet = wb.getSheetAt(sheetnum);
            /* 取得最后一行的行号 */
            int rowNum = sheet.getLastRowNum() + 1;

            /* 行循环开始 */
            for (int i = startrow; i < rowNum; i++) {

                Map varpd = new HashMap<>();
                // 行
                XSSFRow row = sheet.getRow(i);
                /* 每行的最后一个单元格位置 */
                int cellNum = row.getLastCellNum();

                /* 列循环开始 */
                for (int j = startcol; j < cellNum; j++) {

                    XSSFCell cell = row.getCell(Short.parseShort(j + ""));
                    String cellValue = null;
                    if (null != cell) {
                        /* 判断excel单元格内容的格式，并对其进行转换，以便插入数据库 */
                        switch (cell.getCellType()) {
                            case NUMERIC:
                                DecimalFormat df = new DecimalFormat("#");
                                /* 当类型为数值型时，格式化，用以保存数据原始数值，防止数值过长转换科学计数法 */
                                cellValue = String.valueOf(df.format(cell.getNumericCellValue()));
                                break;
                            case STRING:
                                cellValue = cell.getStringCellValue();
                                break;
                            case FORMULA:
                                cellValue = cell.getNumericCellValue() + "";
                                break;
                            case BLANK:
                                cellValue = "";
                                break;
                            case BOOLEAN:
                                cellValue = String.valueOf(cell.getBooleanCellValue());
                                break;
                            case ERROR:
                                cellValue = String.valueOf(cell.getErrorCellValue());
                                break;
                            default:
                                break;
                        }
                    } else {
                        cellValue = "";
                    }
                    varpd.put("var" + j, cellValue);
                }
                varList.add(varpd);
            }
        } catch (IOException | IllegalStateException | NumberFormatException e) {
            com.xiye.common.util.LoggerUtil.error(e.toString(), e);
        }

        return varList;
    }
}
