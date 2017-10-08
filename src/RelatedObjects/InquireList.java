package RelatedObjects;

import java.util.ArrayList;
import java.util.List;

public class InquireList {
    private ArrayList<Inquire> inquires;
    
    public InquireList(){
    	this.inquires = new ArrayList<Inquire>();
    }
    
    public ArrayList<Inquire> getInquirs()
    {
        return inquires;
    }

    public void addInquire(Inquire inquire){
        inquires.add(inquire);
    }

    public void removeInquire(Inquire inquire)
    {
        inquires.remove(inquire);
    }
}
