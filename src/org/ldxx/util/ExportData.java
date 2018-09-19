package org.ldxx.util;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;


public class ExportData {

	
	public void ExportWithResponse(String titleName,  
            String fileName, int columnNumber,
            String [] array, List<List<String>> dataList,  
            HttpServletResponse response) throws Exception {  
            // 第一步，创建一个webbook，对应一个Excel文件  
            HSSFWorkbook wb = new HSSFWorkbook();  
            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
            HSSFSheet sheet = wb.createSheet(titleName);  
            // sheet.setDefaultColumnWidth(15); //统一设置列宽  
            for (int i = 0; i < columnNumber; i++)   
            {  
                for (int j = 0; j <= i; j++)   
                {  
                    if (i == j)   
                    {  
                        sheet.setColumnWidth(i, 20 * 256); // 单独设置每列的宽  
                    }  
                }  
            }  
            // 创建第0行 也就是标题  
            HSSFRow row1 = sheet.createRow((int) 0);  
            row1.setHeightInPoints(50);// 设备标题的高度  
            // 第三步创建标题的单元格样式style2以及字体样式headerFont1  
            HSSFCellStyle style2 = wb.createCellStyle();  
            style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
            style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);  
            style2.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);  
            style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
            HSSFFont headerFont1 = (HSSFFont) wb.createFont(); // 创建字体样式  
            headerFont1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 字体加粗  
            headerFont1.setFontName("黑体"); // 设置字体类型  
            headerFont1.setFontHeightInPoints((short) 15); // 设置字体大小  
            style2.setFont(headerFont1); // 为标题样式设置字体样式  
  
            HSSFCell cell1 = row1.createCell(0);// 创建标题第一列  
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0,  
                    columnNumber - 1)); // 合并列标题  
            cell1.setCellValue(titleName); // 设置值标题  
            cell1.setCellStyle(style2); // 设置标题样式  
  
            // 创建第1行 也就是表头  
            HSSFRow row = sheet.createRow((int) 1);  
            row.setHeightInPoints(37);// 设置表头高度  
  
            // 第四步，创建表头单元格样式 以及表头的字体样式  
            HSSFCellStyle style = wb.createCellStyle();  
            style.setWrapText(true);// 设置自动换行  
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
            style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 创建一个居中格式  
  
            style.setBottomBorderColor(HSSFColor.BLACK.index);  
            style.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
            style.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
            style.setBorderRight(HSSFCellStyle.BORDER_THIN);  
            style.setBorderTop(HSSFCellStyle.BORDER_THIN);  
  
            HSSFFont headerFont = (HSSFFont) wb.createFont(); // 创建字体样式  
            headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 字体加粗  
            headerFont.setFontName("黑体"); // 设置字体类型  
            headerFont.setFontHeightInPoints((short) 10); // 设置字体大小  
            style.setFont(headerFont); // 为标题样式设置字体样式  
  
            // 第四.一步，创建表头的列  
            for (int i = 0; i < columnNumber; i++)   
            {  
                HSSFCell cell = row.createCell(i);  
                cell.setCellValue(array[i]);  
                cell.setCellStyle(style);  
            }  
  
            /*第五步*/
         // 为数据内容设置特点新单元格样式1 自动换行 上下居中  
            HSSFCellStyle zidonghuanhang = wb.createCellStyle();  
            zidonghuanhang.setWrapText(true);// 设置自动换行  
            zidonghuanhang.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 创建一个居中格式  

            // 设置边框  
            zidonghuanhang.setBottomBorderColor(HSSFColor.BLACK.index);  
            zidonghuanhang.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
            zidonghuanhang.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
            zidonghuanhang.setBorderRight(HSSFCellStyle.BORDER_THIN);  
            zidonghuanhang.setBorderTop(HSSFCellStyle.BORDER_THIN);  

            // 为数据内容设置特点新单元格样式2 自动换行 上下居中左右也居中  
            HSSFCellStyle zidonghuanhang2 = wb.createCellStyle();  
            zidonghuanhang2.setWrapText(true);// 设置自动换行  
            zidonghuanhang2  
                    .setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 创建一个上下居中格式  
            zidonghuanhang2.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中  

            // 设置边框  
            zidonghuanhang2.setBottomBorderColor(HSSFColor.BLACK.index);  
            zidonghuanhang2.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
            zidonghuanhang2.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
            zidonghuanhang2.setBorderRight(HSSFCellStyle.BORDER_THIN);  
            zidonghuanhang2.setBorderTop(HSSFCellStyle.BORDER_THIN);  
            
            
            // 第六步，创建单元格，并设置值  
            for (int i = 0; i < dataList.size(); i++)   
            {  
                row = sheet.createRow((int) i + 2);  
                HSSFCell datacell = null;  
                for (int j = 0; j < columnNumber; j++)   {  
                	List<String> list2=dataList.get(i);
                    datacell = row.createCell(j);  
                    datacell.setCellValue(list2.get(j));  
                    datacell.setCellStyle(zidonghuanhang2);  
                }  
            }  
  
            // 第七步，将文件存到浏览器设置的下载位置  
            String filename = fileName + ".xls";  
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setHeader("Content-disposition", "attachment; filename="+new String((filename).getBytes("gb2312"), "ISO8859-1"));  
            OutputStream out = response.getOutputStream();  
            
            try { 
            	if (wb != null) {
            		wb.write(out);// 将数据写出去  
            	}
            } catch (Exception e) {  
                e.printStackTrace();  
                String str1 = "导出" + fileName + "失败！";  
                System.out.println(str1);  
            } finally {  
                out.close();  
            }  
  
    }  
	
}
