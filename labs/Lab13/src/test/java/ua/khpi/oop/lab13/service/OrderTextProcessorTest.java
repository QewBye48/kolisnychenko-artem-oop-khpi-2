package ua.khpi.oop.lab13.service;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab13.model.OrderReport;
import ua.khpi.oop.lab13.model.ProductOrder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTextProcessorTest {

    private final OrderTextProcessor processor = new OrderTextProcessor();

    @Test
    void normalizeTextShouldRemoveExtraSpaces() {
        String result = OrderTextProcessor.normalizeText(
                "  ART-1001;   Ноутбук Lenovo;   QTY=1;   PRICE=42000.50  "
        );

        assertEquals("ART-1001; Ноутбук Lenovo; QTY=1; PRICE=42000.50", result);
    }

    @Test
    void parseLineShouldCreateProductOrder() {
        ProductOrder order = processor.parseLine(
                "ART-1001; Ноутбук Lenovo; QTY=2; PRICE=1000.50"
        );

        assertEquals("ART-1001", order.getArticle());
        assertEquals("Ноутбук Lenovo", order.getProductName());
        assertEquals(2, order.getQuantity());
        assertEquals(1000.50, order.getPrice(), 0.001);
        assertEquals(2001.00, order.getTotalPrice(), 0.001);
    }

    @Test
    void parseLineShouldRejectInvalidArticle() {
        assertThrows(
                IllegalArgumentException.class,
                () -> processor.parseLine("BAD-12; Некоректний товар; QTY=1; PRICE=100.00")
        );
    }

    @Test
    void parseValidLinesShouldSkipInvalidRecords() {
        List<String> lines = List.of(
                "ART-1001; Ноутбук Lenovo; QTY=1; PRICE=42000.50",
                "BAD-12; Некоректний товар; QTY=1; PRICE=100.00",
                "ART-1002; Миша Logitech; QTY=2; PRICE=850.00",
                "   "
        );

        List<ProductOrder> orders = processor.parseValidLines(lines);

        assertEquals(2, orders.size());
        assertEquals("ART-1001", orders.get(0).getArticle());
        assertEquals("ART-1002", orders.get(1).getArticle());
    }

    @Test
    void countInvalidLinesShouldReturnOnlyInvalidRecords() {
        List<String> lines = List.of(
                "ART-1001; Ноутбук Lenovo; QTY=1; PRICE=42000.50",
                "BAD-12; Некоректний товар; QTY=1; PRICE=100.00",
                "ART-1002; Миша Logitech; QTY=2; PRICE=850.00",
                "WRONG TEXT"
        );

        int result = processor.countInvalidLines(lines);

        assertEquals(2, result);
    }

    @Test
    void createReportShouldCalculateSummary() {
        List<String> lines = List.of(
                "ART-1001; Товар 1; QTY=2; PRICE=100.00",
                "ART-1002; Товар 2; QTY=1; PRICE=50.50",
                "BAD-12; Некоректний товар; QTY=1; PRICE=100.00"
        );

        OrderReport report = processor.createReport(lines);

        assertEquals(2, report.getValidRecords());
        assertEquals(1, report.getInvalidRecords());
        assertEquals(250.50, report.getTotalAmount(), 0.001);
    }

    @Test
    void buildReceiptShouldContainSummaryAndProducts() {
        List<String> lines = List.of(
                "ART-1001; Ноутбук Lenovo; QTY=1; PRICE=42000.50",
                "ART-1002; Миша Logitech; QTY=2; PRICE=850.00",
                "BAD-12; Некоректний товар; QTY=1; PRICE=100.00"
        );

        String receipt = processor.buildReceipt(lines);

        assertTrue(receipt.contains("Звіт інтернет-магазину"));
        assertTrue(receipt.contains("Коректних записів: 2"));
        assertTrue(receipt.contains("Некоректних записів: 1"));
        assertTrue(receipt.contains("ART-1001"));
        assertTrue(receipt.contains("Ноутбук Lenovo"));
        assertTrue(receipt.contains("Миша Logitech"));
    }
}