package sky.pro.java.course2.hw20.products;

import java.util.ArrayList;

public class ReceiptBook {
    private final ArrayList<Receipt> receipts;

    public ReceiptBook() {
        receipts = new ArrayList<>();
    }

    public Receipt getReceipt(String receiptName) {
        int index = receipts.indexOf(new Receipt(receiptName));
        if (index >= 0) {
            return receipts.get(index);
        }
        return null;
    }

    public void addReceipt(Receipt receipt) {
        if (receipts.contains(receipt)) {
            throw new IllegalArgumentException("В книге уже есть такой рецепт!");
        }
        receipts.add(receipt);
    }

    public boolean removeReceipt(String receiptName) {
        return receipts.remove(new Receipt(receiptName));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Книга рецептов\n========================================");
        for (Receipt receipt : receipts) {
            stringBuilder.append('\n').append(receipt).append('\n');
        }
        stringBuilder.append('\n').append("========================================");
        return stringBuilder.toString();
    }
}
