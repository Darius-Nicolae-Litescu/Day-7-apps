package darius.model;/*
product

id
name
product_code
picture_href
description
ron_price_per_unit
tax_percentage
available_quantity
 */

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String name;
    private String productCode;
    private String pictureHref;
    private BigDecimal ronPricePerUnit;
    private Integer taxPercentage;
    private Integer availableQuantity;

    List<Review> reviewList;

    public Product() {
    }

    public Product(String name, String productCode, String pictureHref, BigDecimal ronPricePerUnit, Integer taxPercentage, Integer availableQuantity) {
        this.name = name;
        this.productCode = productCode;
        this.pictureHref = pictureHref;
        this.ronPricePerUnit = ronPricePerUnit;
        this.taxPercentage = taxPercentage;
        this.availableQuantity = availableQuantity;
    }

    public Product(Long id, String name, String productCode, String pictureHref, BigDecimal ronPricePerUnit, Integer taxPercentage, Integer availableQuantity) {
        this.id = id;
        this.name = name;
        this.productCode = productCode;
        this.pictureHref = pictureHref;
        this.ronPricePerUnit = ronPricePerUnit;
        this.taxPercentage = taxPercentage;
        this.availableQuantity = availableQuantity;
    }

    public Product(Long id, String name, String productCode, String pictureHref, BigDecimal ronPricePerUnit, Integer taxPercentage, Integer availableQuantity, List<Review> reviewList) {
        this.id = id;
        this.name = name;
        this.productCode = productCode;
        this.pictureHref = pictureHref;
        this.ronPricePerUnit = ronPricePerUnit;
        this.taxPercentage = taxPercentage;
        this.availableQuantity = availableQuantity;
        this.reviewList = reviewList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getPictureHref() {
        return pictureHref;
    }

    public void setPictureHref(String pictureHref) {
        this.pictureHref = pictureHref;
    }

    public BigDecimal getRonPricePerUnit() {
        return ronPricePerUnit;
    }

    public void setRonPricePerUnit(BigDecimal ronPricePerUnit) {
        this.ronPricePerUnit = ronPricePerUnit;
    }

    public Integer getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(Integer taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productCode='" + productCode + '\'' +
                ", picture_href='" + pictureHref + '\'' +
                ", ronPricePerUnit=" + ronPricePerUnit +
                ", taxPercentage=" + taxPercentage +
                ", availableQuantity=" + availableQuantity +
                ", reviewList=" + reviewList +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(productCode, product.productCode) && Objects.equals(pictureHref, product.pictureHref) && Objects.equals(ronPricePerUnit, product.ronPricePerUnit) && Objects.equals(taxPercentage, product.taxPercentage) && Objects.equals(availableQuantity, product.availableQuantity) && Objects.equals(reviewList, product.reviewList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, productCode, pictureHref, ronPricePerUnit, taxPercentage, availableQuantity, reviewList);
    }
}