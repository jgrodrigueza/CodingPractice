package com.msint;
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.ArrayList;

public class TreeNodeCount {

    
    class Tree {
        public int x;
        public Tree l;
        public Tree r;
    }
    

    public ArrayList<Integer> visibleNodesList = new ArrayList(); //Holds the list of visible nodes.
    public int visibleNodes = 0; //Holds the result.

    public void checkTreeNodes(Tree node, int maxVal) {
        
        if (node != null) {
            if (node.x >= maxVal) { //Checks if current node value is greater than the current max value.
                visibleNodes++; //Increments visible nodes count.
                maxVal = node.x;
            }
            checkTreeNodes(node.l, maxVal); //Call to check left node
            checkTreeNodes(node.r, maxVal); //Call to check right node
        }
    }

    public int solution(Tree T) {
        
        if (T != null) { //Prevent null exceptions
            checkTreeNodes(T, 0); //Starts from root.
        }
        return visibleNodes;
        
    }
}