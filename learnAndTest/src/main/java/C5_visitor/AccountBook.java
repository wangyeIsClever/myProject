package C5_visitor;


import java.util.ArrayList;
import java.util.List;

public class AccountBook {

    private List<Bill> bills = new ArrayList<>();

    public void addBill(Bill bill){
        bills.add(bill);
    }

    public void show(Viewer viewer){
        for (Bill bill : bills) {
            bill.view(viewer);
        }
    }

}
