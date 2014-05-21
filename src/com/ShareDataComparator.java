package com;

import java.util.Comparator;



public class ShareDataComparator implements Comparator<Share>{
	 public int compare(Share pFirst, Share pSecond) {
		 try
			{
			 Share abFirst;
			 Share abSecond;
			    int addrResult;
			    abFirst = (Share)pFirst;
			    abSecond = (Share)pSecond;
			    if(Integer.parseInt(abFirst.getSharePrice())>Integer.parseInt(abSecond.getSharePrice()))
			    	return 1;
			    else if(Integer.parseInt(abFirst.getSharePrice())<Integer.parseInt(abSecond.getSharePrice()))
			    	return -1;
			    else
			    	return 0;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			    return 0;
			}
		}

		public ShareDataComparator()
		{
			
		}
	}
