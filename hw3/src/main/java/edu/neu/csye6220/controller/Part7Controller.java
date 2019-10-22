package edu.neu.csye6220.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

@WebServlet(name = "Part7Controller", urlPatterns = {"/part7.xls"})
public class Part7Controller extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("filename");
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
        request.setAttribute("table", resultList);
        request.getRequestDispatcher("WEB-INF/view/part7.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
