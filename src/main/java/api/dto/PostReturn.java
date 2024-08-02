package api.dto;

import api.dto.postreturnsubclasses.Products;


/**
 * This class represents a JSON structure of PostReturn with its attributes and variables already set
 */
public class PostReturn {

    Products[] products = new Products[]{new Products()};


    private String retailerCode = "retailerCode";
}
