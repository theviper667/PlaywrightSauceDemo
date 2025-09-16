package data;

public class ProductData {
    private String productname;
    private String productprice;
    private String productdescription;
    private String productid;

    public ProductData (String productname, String productprice, String productdescription) {
        this.productname = productname;
        this.productprice = productprice;
        this.productdescription = productdescription;
    }

    public ProductData (String productname, String productid) {
        this.productname = productname;
        this.productid = productid;
    }

    public String getProductName() {
        return productname;
    }

    public String getProductPrice() {
        return productprice;
    }

    public String getProductDescription() {
        return productdescription;
    }

    public String getProductID() {
        return productid;
    }
}
