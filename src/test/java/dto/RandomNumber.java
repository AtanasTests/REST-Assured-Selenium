package dto;

import java.util.Random;

public class RandomNumber {

    /**
     *This method generates a random string of 5 digits
     *It utilizes Java's Random class to create random numbers and appends them to a StringBuilder
     *Finally, it converts the StringBuilder to a String and returns it
     *So each time you call this method, you'll get a different random 5-digit number
     */
    public static String generateRandomNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append(random.nextInt(10));

        }
        return sb.toString();

    }
}
