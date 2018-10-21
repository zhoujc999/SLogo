package parsing;

import external.Node;

import java.util.ArrayList;

public class TreeNode implements Node {
    private String myData;
    private ArrayList<TreeNode> myChildren;

    public TreeNode(){
        myChildren = new ArrayList<>();
    }

    public TreeNode(String data){
        myData = data;
        myChildren = new ArrayList<>();
    }

    public String getData(){
        return myData;
    }

    public ArrayList<TreeNode> getChildren(){
        return myChildren;
    }

    public void addChild(Node nwChild){
        myChildren.add((TreeNode) nwChild);
    }

    public void setData(String nwData){
        myData = nwData;
    }



}
