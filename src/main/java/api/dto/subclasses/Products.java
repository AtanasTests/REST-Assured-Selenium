package api.dto.subclasses;


/**
 * This class represents a JSON "Products" object with its attributes and variables already set
 */
public class Products {

    ProductInformation[] productInformation = new ProductInformation[]{new ProductInformation()};
    Prices[] prices = new Prices[]{new Prices()};

    private String orderLineItemNumber = "15r";
    private String sku =  "sku";
    private int returnPeriodInDays = 150;
    private String masterSku = "masterSku";
    private String brand = "brand";
    private String gtin = "gtin";
    private String hsCode = "hsCode";
    private String importHSCode = "importHSCode";
    private String gBEori = "gBEori";
    private String euEori = "euEori";
    private String xiEori = "xiEori";
    private String customsProcedureCode = "customsProcedureCode";
    private String returnsGoodsRelief = "returnsGoodsRelief";
    private String condition = "condition";
    private String availability = "availability";
    private String salePriceEffectiveDate = "salePriceEffectiveDate";
    private int quantity = 5;
    private int price = 5;
    private int itemWeight = 1;
    private boolean eligibleForFreeShipping = true;
    private String warehouseDcCode = "warehouseDcCode";
}
