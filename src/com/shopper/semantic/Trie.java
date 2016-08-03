package com.shopper.semantic;


class Trie1 {

	private static final TrieNode NULL = null;

	private TrieNode root;
	
	private int numWords;
	

	

	boolean addWord(TrieNode node, char word[],int i) {
		if (word[i] == '\0') {
			if (node.isTerminal) {
				return false;
			}

			node.isTerminal = true;
			return true;
		}

		TrieNode child = node.getChildForChar(word[i]);
		if (child == NULL) {
			child = new TrieNode(word[i]);
			node.setChild(child);
		}

		return addWord(child, word,i+1);
	}

	
	

	public Trie1() {
		super();
		root = new TrieNode('\0');
		numWords = 0;//////
	}

	int numberWords() {
		return numWords;
	}

	

	boolean findWord(char word[]) {
		TrieNode currentNode = root;
		for (int i = 0; word[i] != '\0'; i++) {
			TrieNode child = currentNode.getChildForChar(word[i]);
			if (child == NULL) {
				return false;
			}
			currentNode = child;
		}
		return currentNode.isTerminal;
	}

	void addWord(char word[]) {
		boolean added = addWord(root, word,0);
		if (added)
			numWords++;
	}

	
};



