package api.dto.subclasses;


/**
 * This class represents a JSON "BillingContact" object with its attributes and variables already set
 */
public class BillingContact {

    Address address = new Address();

    private String firstName = "Charlie";
    private String salutation = "Mr.";
    private String email = "CharlieHarper@email.com";
    private String lastName = "Harper";
    private String zipCode = "zipCode";
}
