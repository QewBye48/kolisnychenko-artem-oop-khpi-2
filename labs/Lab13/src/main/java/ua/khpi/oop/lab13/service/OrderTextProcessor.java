package ua.khpi.oop.lab13.service;

import ua.khpi.oop.lab13.model.OrderReport;
import ua.khpi.oop.lab13.model.ProductOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderTextProcessor {
    private static final Pattern ORDER_PATTERN = Pattern.compile(
            "^(ART-\\d{4});\\s*(.+?);\\s*QTY=(\\d+);\\s*PRICE=(\\d+(?:\\.\\d{1,2})?)$"
    );

    public static String normalizeText(String line) {
        if (line == null) {
            return "";
        }

        return line.trim().replaceAll("\\s+", " ");
    }

    public ProductOrder parseLine(String rawLine) {
        String line = normalizeText(rawLine);
        Matcher matcher = ORDER_PATTERN.matcher(line);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Некоректний запис товару: " + rawLine);
        }

        String article = matcher.group(1);
        String productName = matcher.group(2).trim();
        int quantity = Integer.parseInt(matcher.group(3));
        double price = Double.parseDouble(matcher.group(4));

        return new ProductOrder(article, productName, quantity, price);
    }

    public List<ProductOrder> parseValidLines(List<String> rawLines) {
        List<ProductOrder> orders = new ArrayList<>();

        for (String rawLine : rawLines) {
            String line = normalizeText(rawLine);

            if (line.isBlank()) {
                continue;
            }

            try {
                orders.add(parseLine(line));
            } catch (IllegalArgumentException exception) {
                // Некоректні записи пропускаються, але враховуються у звіті окремо.
            }
        }

        return orders;
    }

    public int countInvalidLines(List<String> rawLines) {
        int invalidCount = 0;

        for (String rawLine : rawLines) {
            String line = normalizeText(rawLine);

            if (line.isBlank()) {
                continue;
            }

            try {
                parseLine(line);
            } catch (IllegalArgumentException exception) {
                invalidCount++;
            }
        }

        return invalidCount;
    }

    public OrderReport createReport(List<String> rawLines) {
        List<ProductOrder> orders = parseValidLines(rawLines);
        int invalidCount = countInvalidLines(rawLines);

        double totalAmount = 0.0;

        for (ProductOrder order : orders) {
            totalAmount += order.getTotalPrice();
        }

        return new OrderReport(orders.size(), invalidCount, totalAmount);
    }

    public String buildReceipt(List<String> rawLines) {
        List<ProductOrder> orders = parseValidLines(rawLines);
        OrderReport report = createReport(rawLines);

        StringBuilder builder = new StringBuilder();

        builder.append("Звіт інтернет-магазину\n");
        builder.append("Коректних записів: ").append(report.getValidRecords()).append('\n');
        builder.append("Некоректних записів: ").append(report.getInvalidRecords()).append('\n');
        builder.append("Загальна сума: ")
                .append(String.format(Locale.US, "%.2f", report.getTotalAmount()))
                .append(" грн\n\n");

        builder.append("Товари:\n");

        for (ProductOrder order : orders) {
            builder.append("- ")
                    .append(order.getArticle())
                    .append(" | ")
                    .append(order.getProductName())
                    .append(" | ")
                    .append(order.getQuantity())
                    .append(" шт. | ")
                    .append(String.format(Locale.US, "%.2f", order.getPrice()))
                    .append(" грн | сума: ")
                    .append(String.format(Locale.US, "%.2f", order.getTotalPrice()))
                    .append(" грн\n");
        }

        return builder.toString();
    }
}