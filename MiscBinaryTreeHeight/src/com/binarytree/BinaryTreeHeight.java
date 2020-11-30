package com.binarytree;

public class BinaryTreeHeight {

	static class TreeNode {
	    
		int nodeVal;
	    TreeNode left;
	    TreeNode right;

	    TreeNode(int nodeVal) {
	        this.nodeVal = nodeVal;
	    }
	
	}

	public static int maxHeight(TreeNode treeNode) {

		int t1l = 0;
	    int t2l = 0;
	    
	    if(treeNode.left != null){
	        t1l = 1 + maxHeight(treeNode.left);
	    }
	    if(treeNode.right != null){
	        t2l = 1 + maxHeight(treeNode.right);
	    }
	    
	    return Math.max(t1l, t2l);
	}
	
	public static void main(String[] args) {
	    
		TreeNode rootNode = new TreeNode(5);
	    rootNode.left = new TreeNode(3);
	    rootNode.right = new TreeNode(10);
	    
	    rootNode.left.left = new TreeNode(20);
	    rootNode.left.right = new TreeNode(21);
	     
	    rootNode.right.left = new TreeNode(1);
	    
	    System.out.println("Height: " + maxHeight(rootNode));
	     
	}
	
}
