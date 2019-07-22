package C5_visitor;

import java.math.BigDecimal;

public class IncomeBill implements Bill {

    private BigDecimal amount;

    private String item;

    public IncomeBill(BigDecimal amount, String item) {
        this.amount = amount;
        this.item = item;
    }

    @Override
    public void view(Viewer viewer) {
        viewer.view(this);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
