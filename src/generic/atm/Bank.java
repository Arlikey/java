package generic.atm;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final List<ATM> atms;

    public Bank(List<ATM> atms) {
        this.atms = atms;
    }

    public int getTotalCashInNetwork() {
        int total = 0;
        for (ATM atm : atms) {
            total += atm.getTotalAmount();
        }
        return total;
    }
}
