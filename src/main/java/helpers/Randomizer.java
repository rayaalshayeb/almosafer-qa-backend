package helpers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Randomizer {

    static String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String randomAlphanumericString(int length) {
        Random random = new Random();
        StringBuilder randomString = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(upperAlphabet.length());
            char randomChar = upperAlphabet.charAt(randomIndex);
            randomString.append(randomChar);
        }

        return randomString.toString();
    }

    public int randomInteger() {
        Random random = new Random();
        return random.nextInt(5000);
    }

    public String tripFromDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public String tripToDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public String selectRandomCity() {
        String[] cities = {"RUH", "JED"};
        Random random = new Random();
        int randomIndex = random.nextInt(cities.length);
        return cities[randomIndex];
    }
}
