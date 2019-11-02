package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exlreader {

	static FileInputStream fis = null ;

	public FileInputStream getfileinputstream ()  
	{
		String filepath =System.getProperty("user.dir")+"\\data\\Data.xlsx" ;
		File srcfile = new File(filepath);

		try {
			fis = new FileInputStream(srcfile);
		} catch (FileNotFoundException e) {
			System.out.println("the data file not found" + e);
		}
		return fis;


	}

	public Object[][] GetExlData (int sheetNum , int TotalColum) throws IOException
	{
		fis = getfileinputstream();
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			System.out.println("the data file not found" + e);
		}
		XSSFSheet sheet = workbook.getSheetAt(sheetNum);
		int totalNumberOfrows = (sheet.getLastRowNum()+1);
		int totalNumberOfCoulems = TotalColum ;
		String [][] arrayExlData = new String[totalNumberOfrows][totalNumberOfCoulems];
		for (int i = 0; i < totalNumberOfrows; i++) 
		{
			for (int j = 0; j < totalNumberOfCoulems; j++) {
				XSSFRow row = sheet.getRow(i);
				arrayExlData[i][j] = row.getCell(j).toString();
			}
		}

		workbook.close();
		return arrayExlData; 

	}
}