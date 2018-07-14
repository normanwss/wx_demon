package com.example.wc.utils.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.WorkbookUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;

public class WorkbookHelper extends WorkbookUtil {

    public static final short FONT_SIZE = (short) (12 * 20);

    public static void createHeaderCell(Workbook wb, Row row, int column, String title) {
        Cell cell = row.createCell(column);
        cell.setCellValue(title);
        CellStyle cellStyle = wb.createCellStyle();
        Font font = wb.createFont();
        font.setBold(true);
        font.setFontHeight(FONT_SIZE);
        cellStyle.setFont(font);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        cell.setCellStyle(cellStyle);
    }

    public static CellStyle createNormalCellStyle(Workbook wb) {
        CellStyle cellStyle = wb.createCellStyle();
        Font font = wb.createFont();
        font.setBold(false);
        font.setFontHeight(FONT_SIZE);
        cellStyle.setFont(font);
        cellStyle.setAlignment(HorizontalAlignment.LEFT);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        return cellStyle;
    }

    public static CellStyle createNormalCellStyle(Workbook wb, HorizontalAlignment horizontalAlignment) {
        CellStyle cellStyle = wb.createCellStyle();
        Font font = wb.createFont();
        font.setBold(false);
        font.setFontHeight(FONT_SIZE);
        cellStyle.setFont(font);
        cellStyle.setAlignment(horizontalAlignment);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        return cellStyle;
    }

    public static void createCell(Row row, int column, CellStyle cellStyle, String title) {
        Cell cell = row.createCell(column);
        cell.setCellValue(title);
        cell.setCellStyle(cellStyle);
    }

    public static void createIntCell(Row row, int i, CellStyle cellStyle, int number) {
        Cell cell = row.createCell(i);
        cell.setCellValue(number);
        cell.setCellStyle(cellStyle);
    }

    public static void createBigDecimalCell(Row row, int i, CellStyle cellStyle, BigDecimal bigDecimal) {
        Cell cell = row.createCell(i);
        if(bigDecimal != null){
            cell.setCellValue(bigDecimal.doubleValue());
        }
        cell.setCellStyle(cellStyle);
    }

    public static void createDateCell(Row row, int i, CellStyle cellStyle, Date date) {
        Cell cell = row.createCell(i);
        cell.setCellValue(date);
        cell.setCellStyle(cellStyle);
    }

    public static void main(String[] args) throws IOException {
//        Workbook wb = new HSSFWorkbook();
//        String safeName = WorkbookUtil.createSafeSheetName("订单统计");
//        Sheet sheet = wb.createSheet(safeName);
//        Row row = sheet.createRow(0);
//        createHeaderCell(wb, row, 0, "订单号");
//        createHeaderCell(wb, row, 1, "门店");
//        createHeaderCell(wb, row, 2, "用户昵称");
//        createHeaderCell(wb, row, 3, "订单金额");
//        createHeaderCell(wb, row, 4, "折扣金额");
//        createHeaderCell(wb, row, 5, "支付方式");
//        createHeaderCell(wb, row, 6, "状态");
//        createHeaderCell(wb, row, 7, "下单时间");
//        createHeaderCell(wb, row, 8, "付款时间");
//        createHeaderCell(wb, row, 9, "取酒时间");
//
//        for (int colNum = 0; colNum < row.getLastCellNum(); colNum++) {
//            wb.getSheetAt(0).autoSizeColumn(colNum);
//        }
//
//        FileOutputStream fileOut = new FileOutputStream("workbook.xls");
//        wb.write(fileOut);
//        fileOut.close();

        InputStream inp = new FileInputStream("/Users/justin/Downloads/ChinaDistrict.xls");
        //InputStream inp = new FileInputStream("workbook.xlsx");

        Workbook wb = new HSSFWorkbook(inp);
        Sheet sheet = wb.getSheetAt(0);
        sheet.removeRow(sheet.getRow(0));
        Iterator<Row> iterator = sheet.rowIterator();
        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()) {
            Row row = iterator.next();
            if (row.getCell(6) != null) {
                stringBuilder.append("UPDATE cities SET area_code = '" + row.getCell(6) + "' WHERE name = '" + row.getCell(1) + "' ").append(";");
            }
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                System.err.println(cellIterator.next().getStringCellValue());
            }

        }
        System.err.println(stringBuilder);

    }


    public static CellStyle createCurrencyCellStyle(Workbook wb) {
        CellStyle cellStyle = wb.createCellStyle();
        Font font = wb.createFont();
        font.setBold(false);
        font.setFontHeight(FONT_SIZE);
        cellStyle.setFont(font);
        cellStyle.setAlignment(HorizontalAlignment.RIGHT);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        return cellStyle;
    }

    public static CellStyle createDateCellStyle(Workbook wb) {
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setDataFormat(wb.getCreationHelper().createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
        Font font = wb.createFont();
        font.setBold(false);
        font.setFontHeight(FONT_SIZE);
        cellStyle.setFont(font);
        cellStyle.setAlignment(HorizontalAlignment.RIGHT);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        return cellStyle;
    }

    public static CellStyle createDateCellStyle(Workbook wb, String dateFormatPattern) {
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setDataFormat(wb.getCreationHelper().createDataFormat().getFormat(dateFormatPattern));
        Font font = wb.createFont();
        font.setBold(false);
        font.setFontHeight(FONT_SIZE);
        cellStyle.setFont(font);
        cellStyle.setAlignment(HorizontalAlignment.RIGHT);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        return cellStyle;
    }
}
