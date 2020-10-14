package domain;

import utils.PropertiesUtil;

import java.io.Serializable;
import java.util.Objects;
import java.util.Properties;

public class Product implements Serializable {
    private static Product product = null;

    private String productNumber;
    private String productCategory;

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public static Product setProduct() {
        Properties properties = PropertiesUtil.loadProperties("product.properties");

        if (Objects.isNull(product)) {
            product = new Product();
        }

        product.setProductNumber(properties.getProperty("productNumber"));
        product.setProductCategory(properties.getProperty("productCategory"));
        return product;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productNumber='" + productNumber + '\'' +
                '}';
    }
}
