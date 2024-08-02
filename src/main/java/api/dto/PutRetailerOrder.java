package api.dto;

import api.dto.subclasses.BillingContact;
import api.dto.subclasses.Products;
import api.dto.subclasses.ShippingContact;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * This class represents a JSON structure of PutRetailerOrder object with its attributes and variables already set
 */
public class PutRetailerOrder {

    BillingContact billingContact = new BillingContact();

    ShippingContact shippingContact = new ShippingContact();



    private String orderDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    private String email = "CharlieHarper@email.com";
    private int total = 220;
    private int totalWeight = 35;
    private String currencyIso3Code = "currencyIso3Code";
    private String externalReference = "externalReference";
    private int shippingCost = 10;
    private String trackingNumber = "trackingNumber";
    private String retailerCode = "retailerCode";
    private String retailerName = "retailerName";
    private String account = "account";
    private int numberOfParcels = 1;
    private String weightUnitOfMeasure = "kg";
    private String incoterms = "incoterms";
    private String airwayBillNumber = "123456";
    private String iossNumber = "iossNumber";

    private final Products[] products = new Products[] {new Products()};
}
