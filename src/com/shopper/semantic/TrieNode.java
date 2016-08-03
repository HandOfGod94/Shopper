package com.shopper.semantic;


public class TrieNode {
	 private static final TrieNode NULL = null;
	TrieNode[] children = new TrieNode[26];
	
	char data;
	boolean isTerminal;
	
	TrieNode(char data) {
		isTerminal = false;
		this.data = data;
		children = new TrieNode[26];
		for (int i = 0; i < 26; i++) {
			children[i] = NULL;
		}
	}

	int childCount() {
		int count = 0;
		for (int i = 0; i < 26; i++) {
			if (children[i] != NULL)
				count++;
		}
		return count;
	}

	
	

	void setChild(TrieNode child) {
		if (child == NULL) {
			return;
		}
		/*if (children[child.data - 'a'] != NULL) {
			delete children[child.data - 'a'];
		}*/
		children[child.data - 'a'] = child;
	}

	TrieNode getChildForChar(char c) {
		return children[c - 'a'];
	}

};


