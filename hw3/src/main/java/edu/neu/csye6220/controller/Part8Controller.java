package edu.neu.csye6220.controller;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Part8Controller extends AbstractController {
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String filename = httpServletRequest.getParameter("filename");
        String path = "C:\\Users\\zhaoc\\Documents\\GitHub\\CSYE6220\\hw3\\web\\WEB-INF\\"+filename;
        List<List<String>> resultList = new ArrayList<List<String>>();
        try{
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream( new File(path)));
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.rowIterator();
            while (rowIterator.hasNext()) {
                List<String> sublist = new ArrayList<String>();
                Row row = rowIterator.next();
                DataFormatter dataFormatter = new DataFormatter();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    String cellValue = dataFormatter.formatCellValue(cell);
                    sublist.add(cellValue);
                }
                resultList.add(sublist);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ModelAndView("part8").addObject("table2", resultList);
    }
}
