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

    public void addChild(Node nwChild) throws IllegalAccessException{
        if(nwChild instanceof TreeNode){
            myChildren.add((TreeNode) nwChild);
        }
        else{
            throw new IllegalAccessException();
        }
    }

    public void setData(String nwData){

    }



}
