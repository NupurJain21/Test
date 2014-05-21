package com;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class TestSample {
	private int lineNumber = 0;
	private HashMap<String, String> headerData = new HashMap<String, String>();
	public static void main(String[] args) {
		TestSample obj = new TestSample();
		obj.run(args[0]);
	  }
	public String run(String filepath) {
		String csvFile = filepath;
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				lineNumber++;
				String[] data = line.split(cvsSplitBy);
				String result = find(data);
				if(result!=null)System.out.println("Result Using file => " + result);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "Done";
	  }
	public String find(String[] data){
		String Result = null;
		String result[] = new String[3];
		if(lineNumber== 1){
			for(int i = 0; i<data.length; i++){
				headerData.put(""+i, data[i]);
			}
		}
		if(lineNumber!= 1){
			HashMap<String, String> dataMap = new HashMap<String, String>();
			ArrayList<Share> shareArrayList = new ArrayList<Share>();
			for(int i = 2; i<data.length; i++){
				Share shareData  = new Share();
				shareData.setMonth(data[1]);
				shareData.setYear(data[0]);
				shareData.setSharePrice(data[i]);
				if(!headerData.isEmpty())shareData.setCompany(headerData.get(""+i));
				else{
					shareData.setCompany("Company"+(i-1));
				}
				shareArrayList.add(shareData);
			}
			Collections.sort(shareArrayList, new ShareDataComparator());
			result[0] = shareArrayList.get(shareArrayList.size()-1).getMonth();
			result[1] = shareArrayList.get(shareArrayList.size()-1).getCompany();
			result[2] = shareArrayList.get(shareArrayList.size()-1).getYear();
			Result = "Year= "+result[2]+" month= "+result[0]+" Company= "+result[1];
		}
		return Result;
	}
}
