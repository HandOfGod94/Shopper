package com.shopper.semantic;

public enum SemanticResult
{
	GOOD, BAD, NEUTRAL;
	
	@Override
	public String toString() 
	{
		switch (this)
		{
			case GOOD: return "Good";
			case BAD: return "Bad";
			case NEUTRAL: return "Neutral";
			default:
				throw new IllegalArgumentException();
		}
	};
}
