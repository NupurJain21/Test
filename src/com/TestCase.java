package com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestCase extends junit.framework.TestCase {
	private String parameter;
	
	public static void testMethod() throws FileNotFoundException 
	 {
		 String filePath = "D:\\IBM\\WCDE_ENT70\\workspace\\Test\\src\\com\\test-csv.csv";
	   FileInputStream data = new FileInputStream(filePath); 
	   checkFileExtension(filePath);
	 }
	public static void checkFileExtension(String filePath){
		 String extension = "";
		 int i = filePath.lastIndexOf('.');
		 if (i >= 0) {
		     extension = filePath.substring(i+1);
		 }
		 if(extension.equals("csv")){
			 getResult(filePath);
		 }else{
			System.out.println("Please pass the csv file.");
		 }
	 }
	public static void getResult(String filePath) {
		TestSample tester = new TestSample();
		tester.run(filePath);
	}
	public static void testByData() {
		TestSample tester = new TestSample();
		String[] inputData = {"2014","May","10","35","6","12","64","40","11","33","35","32"};
		String result = null;
	    assertEquals(result, tester.find(inputData));
	    assertNotNull(result);
	    System.out.println("Result Using Data => " + result);
	}

}
