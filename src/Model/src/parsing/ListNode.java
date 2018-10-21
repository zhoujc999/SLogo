package parsing;

public class ListNode{
    private String myData;
    private ListNode myChild;

    public ListNode(String data){
        myData = data;
    }

    public ListNode(String data, ListNode node){
        myData = data;
        myChild = node;
    }

    public String getData(){
        return myData;
    }

    public ListNode getChild(){
        return myChild;
    }

    public void setChild(ListNode nwChild){
        myChild = nwChild;
    }

    public void setData(String nwData){
        myData = nwData;
    }
}
