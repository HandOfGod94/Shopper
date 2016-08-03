package com.shopper.semantic;

//import java.util.ArrayList;

public class mainclass {

	public static int getResult(String input) {

		Trie1 good = new Trie1();
		Trie1 bad = new Trie1();
		Trie1 neg = new Trie1();

		String[] goodWordsDict = "good better waah furr".split(" ");
		String[] badWordDict = "worst bad worse".split(" ");
		String[] negationWordDict = "not no anti".split(" ");

		for (String s : goodWordsDict)
			good.addWord((s + "\0").toCharArray());

		for (String s : badWordDict)
			bad.addWord((s + "\0").toCharArray());
		for (String s : negationWordDict)
			neg.addWord((s + "\0").toCharArray());

		int flag = 0;
		int count = 0;

		String[] inputStr = input.split(" +");

		for (String word : inputStr) {
			word += "\0";
			if (neg.findWord(word.toCharArray()))
				flag = 1;
			else {
				if (bad.findWord(word.toCharArray()))
					if (flag == 0)
						count--;
					else
						count++;
				else if (good.findWord(word.toCharArray()))
					if (flag == 0)
						count++;
					else
						count--;
			}
		}

		return count;
	}

}
