package com.binarytree;

import java.util.ArrayList;
import java.util.Arrays;

public class BinaryTreeCount {
	 
	static ArrayList<Integer> visibleNodes = new ArrayList<>();

	static class TreeNode {
	    
		int nodeVal;
	    TreeNode left;
	    TreeNode right;

	    TreeNode(int nodeVal) {
	        this.nodeVal = nodeVal;
	    }
	
	}
	 
	private static void checkNodeVals(TreeNode treeNode, int max) {
	    
		if (treeNode == null) {
	        return;
	    }
	     
	    if (treeNode.nodeVal >= max) {
	        visibleNodes.add(treeNode.nodeVal);
	        max = Math.max(treeNode.nodeVal, max);
	    }
	    
	    checkNodeVals(treeNode.left, max);
	    checkNodeVals(treeNode.right, max);
	}
	
	public static int maxHeight(TreeNode treeNode) {

		int val1 = 0;
	    int val2 = 0;
		if (treeNode != null) {
		    if (treeNode.left != null) {
		        val1 = 1 + maxHeight(treeNode.left);
		    }
		    if (treeNode.right != null) {
		        val2 = 1 + maxHeight(treeNode.right);
		    }
		}
	    return Math.max(val1, val2);
	}
	 
	public static void main(String[] args) {
	    
		TreeNode rootNode = new TreeNode(5);
	    rootNode.left = new TreeNode(3);
	    rootNode.right = new TreeNode(10);
	    rootNode.left.left = new TreeNode(20);
	    rootNode.left.right = new TreeNode(21);
	    rootNode.right.left = new TreeNode(1);
	    rootNode.right.right = new TreeNode(6);    
	    rootNode.right.left.right = new TreeNode(11);
	    rootNode.right.left.right.left = new TreeNode(25);
	     
	    checkNodeVals(rootNode, 0);
	    int treeHieght = maxHeight(rootNode);
	    
	    System.out.println("Tree Height: " + treeHieght + ", Visible Nodes: " + visibleNodes.size() + ", Array: " + Arrays.toString(visibleNodes.toArray()));
	    
	}
}