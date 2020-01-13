package com.util;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public static void readExcel(String filePath, String fileName, String sheetName) throws IOException {

		File file = new File(filePath + "\\" + fileName);
		FileInputStream inputStream = new FileInputStream(file);

		Workbook guru99Workbook = null;
		String fileExtensionName = fileName.substring(fileName.indexOf("."));


		if (fileExtensionName.equals(".xlsx")) {
			guru99Workbook = new XSSFWorkbook(inputStream);
		}
		else if (fileExtensionName.equals(".xls")) {
			guru99Workbook = new HSSFWorkbook(inputStream);
		}

		Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);
		int rowCount = guru99Sheet.getLastRowNum() - guru99Sheet.getFirstRowNum();

		for (int i = 0; i < rowCount + 1; i++) {
			Row row = guru99Sheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				System.out.print(row.getCell(j).getStringCellValue() + "|| ");
			}
			System.out.println();
		}
	}

	// Main function is calling readExcel function to read data from excel file
	public static void main(String... strings) throws IOException {
		String filePath = System.getProperty("user.dir");

		// Call read file method of the class to read data

		readExcel(filePath, "ExportExcel.xlsx", "ExcelGuru99Demo");

		/////////////////////
		// Create an array with the data in the same order in which you expect to be
		///////////////////// filled in excel file

		String[] valueToWrite = { "Mr. E", "Noida" };

		// Create an object of current class

		// Write the file using file name, sheet name and the data to be filled

		writeExcel(System.getProperty("user.dir"), "ExportExcel.xlsx", "ExcelGuru99Demo", valueToWrite);

	}

	public static void writeExcel(String filePath, String fileName, String sheetName, String[] dataToWrite)
			throws IOException {
		File file = new File(filePath + "\\" + fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook guru99Workbook = null;

		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		if (fileExtensionName.equals(".xlsx")) {
			guru99Workbook = new XSSFWorkbook(inputStream);
		}
		else if (fileExtensionName.equals(".xls")) {
			guru99Workbook = new HSSFWorkbook(inputStream);
		}

		Sheet sheet = guru99Workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		Row row = sheet.getRow(0);
		Row newRow = sheet.createRow(rowCount + 1);

		// Create a loop over the cell of newly created Row
		for (int j = 0; j < row.getLastCellNum(); j++) {
			Cell cell = newRow.createCell(j);
			cell.setCellValue(dataToWrite[j]);
		}

		// Close input stream
		inputStream.close();

		// Create an object of FileOutputStream class to create write data in excel file
		FileOutputStream outputStream = new FileOutputStream(file);

		// write data in the excel file
		guru99Workbook.write(outputStream);

		// close output stream
		outputStream.close();
	}
}
