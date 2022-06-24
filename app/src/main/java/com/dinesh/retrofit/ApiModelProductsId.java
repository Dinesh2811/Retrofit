package com.dinesh.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiModelProductsId {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("price")
    @Expose
    public Integer price;
    @SerializedName("quantity")
    @Expose
    public Integer quantity;
    @SerializedName("total")
    @Expose
    public Integer total;
    @SerializedName("discountPercentage")
    @Expose
    public Double discountPercentage;
    @SerializedName("discountedPrice")
    @Expose
    public Integer discountedPrice;

    public ApiModelProductsId(Integer id, String title, Integer price, Integer quantity, Integer total, Double discountPercentage, Integer discountedPrice) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
        this.discountPercentage = discountPercentage;
        this.discountedPrice = discountedPrice;
    }

    public ApiModelProductsId() {
    }

    @Override
    public String toString() {
        return "ApiModelProductsId{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", total=" + total +
                ", discountPercentage=" + discountPercentage +
                ", discountedPrice=" + discountedPrice +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Integer getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(Integer discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
}
