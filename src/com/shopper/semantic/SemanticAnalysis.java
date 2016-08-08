package com.shopper.semantic;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;

import com.shopper.dao.UserCommentCRUD;

public class SemanticAnalysis
{
	public static final int GOOD_RATING_THRESHOLD = 7;
	public static final int BAD_RATING_THRESHOLD = 3;
	
	/**
	 * Collects all the comments of a particular product and 
	 * returns 
	 * @param productId
	 * @return SemanticResult Enum
	 */
	private static SemanticResult getResult(String productId)
	{
		int rating;
		String comment;
		int count = 0;
	
		// Get all the comments of a product using productId.
		ArrayList<SimpleEntry<Integer, String>> comments = UserCommentCRUD.read(productId);
		
		for(SimpleEntry<Integer, String> entry: comments)
		{
			rating = entry.getKey();
			comment = entry.getValue();
			if (rating >= GOOD_RATING_THRESHOLD)
				count++;
			else if (rating <= BAD_RATING_THRESHOLD)
				count--;
			else
				count += mainclass.getResult(comment);
		}
		if (count > 0 )
			return SemanticResult.GOOD;
		else if ( count==0 )
			return SemanticResult.NEUTRAL;
		else
			return SemanticResult.BAD;
	}
	
	public static ArrayList<SemanticResult> getListOfSemanticResults(ArrayList<String> productIds)
	{
		ArrayList<SemanticResult> result = new ArrayList<SemanticResult>();
		for(String id:productIds)
			result.add(getResult(id));
		return result;
	}
}
