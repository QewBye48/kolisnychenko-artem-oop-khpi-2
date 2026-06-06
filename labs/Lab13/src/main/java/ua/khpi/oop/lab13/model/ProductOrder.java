package ua.khpi.oop.lab13.model;

public class ProductOrder {
    private final String article;
    private final String productName;
    private final int quantity;
    private final double price;

    public ProductOrder(String article, String productName, int quantity, double price) {
        if (article == null || article.isBlank()) {
            throw new IllegalArgumentException("Артикул не може бути порожнім");
        }
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Назва товару не може бути порожньою");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Кількість має бути додатною");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Ціна має бути додатною");
        }

        this.article = article;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getArticle() {
        return article;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getTotalPrice() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return article + " | " + productName + " | кількість: " + quantity + " | ціна: " + price + " | сума: " + getTotalPrice();
    }
}