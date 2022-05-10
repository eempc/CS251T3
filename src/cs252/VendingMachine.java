package cs252;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    private Map<Item, Integer> stockAndQuantity = new HashMap<>();
    public Map<Item, Integer> getCurrentStockAndQuantity() {
        return stockAndQuantity;
    }
    public List<SalesRecord> salesLedger = new ArrayList<>();
    public void setInitialStockAndQuantity(Map<Item, Integer> stockAndQuantity) {
        this.stockAndQuantity = stockAndQuantity;
    }
    public void addItemAndQuantity(Item item, int quantity) {}
    public void sellSingleItem(Item item, Customer customer) {}
    public void setupPrices(Item item, int price) {}
    private void recordSale(Item item, SmartCard smartCard) {}
    public void printSalesRecordStatistics() {}
}
