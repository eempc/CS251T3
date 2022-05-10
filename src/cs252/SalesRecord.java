package cs252;

import java.time.LocalDateTime;

public class SalesRecord {
    private int id;
    private SmartCard smartCard;
    private Item item;
    private LocalDateTime saleTime;

    public SalesRecord(int id, SmartCard smartCard, Item item) {
        this.id = id;
        this.smartCard = smartCard;
        this.item = item;
        this.saleTime = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public SmartCard getSmartCard() {
        return smartCard;
    }

    public Item getItem() {
        return item;
    }

    public LocalDateTime getSaleTime() {
        return saleTime;
    }
}
