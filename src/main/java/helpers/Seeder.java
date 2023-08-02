package helpers;

import com.github.javafaker.Faker;
import lombok.Setter;
import models.PostRewardsMetaRequestModel;
import models.PostRewardsRequestModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Seeder {

    final Faker faker = new Faker();

    @Setter
    String productType, currency, method, couponCode, airlineCode, tripFrom, tripTo, origin, destination;
    String[] productTypes = new String[]{"flight", "hotel", "accommodation", "activity"};
    String[] methods = new String[]{"mokafa", "qitaf"};
    String[] cities = new String[]{"RUH", "JED", "AAR", "ABD", "ABI", "ADA", "AAN", "ESF", "AMM", "SFA", "ALP", "JUB"};
    String[] currencies = new String[]{"SAR", "AED", "QAR", "KWD", "BHD", "USD", "EUR", "GBP", "EGP", "INR", "OMR"};
    @Setter
    int productPriceTotal, productPriceTax, productPriceBase, totalWithoutVat;
    @Setter
    double netAmount;
    @Setter
    boolean domestic, international;

    public LocalDateTime generateRandomDate() {
        int year = faker.number().numberBetween(LocalDateTime.now().getYear(), LocalDateTime.now().getYear() + 1);
        int month = faker.number().numberBetween(LocalDateTime.now().getMonthValue(), 12);
        int day = faker.number().numberBetween(1, 28);
        int hour = faker.number().numberBetween(1, 12);
        int minute = faker.number().numberBetween(1, 60);

        return LocalDateTime.of(year, month, day, hour, minute);
    }

    public void getDates() {
        LocalDateTime tripFromDate = generateRandomDate();
        LocalDateTime tripToDate = tripFromDate.plusDays(faker.number().numberBetween(1, 30));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        setTripFrom(tripFromDate.format(dateTimeFormatter));
        setTripTo(tripToDate.format(dateTimeFormatter));
    }

    public String getRandomItemFromArray(String[] items) {
        return faker.options().option(items);
    }

    public void generateData() {
        String randomMethod = getRandomItemFromArray(methods);

        setProductType(getRandomItemFromArray(productTypes));
        setCouponCode(faker.lorem().fixedString(3).toUpperCase());
        setAirlineCode(faker.lorem().fixedString(2).toUpperCase());
        setMethod(randomMethod);
        setCurrency(randomMethod == "qitaf" ? currencies[0] : getRandomItemFromArray(currencies));
        setOrigin(getRandomItemFromArray(cities));
        setDestination(getRandomItemFromArray(cities));
        setProductPriceBase(faker.number().randomDigitNotZero());
        setProductPriceTax(faker.number().randomDigitNotZero());
        setProductPriceTotal(faker.number().randomDigitNotZero());
        setTotalWithoutVat(faker.number().randomDigitNotZero());
        setDomestic(faker.bool().bool());
        setInternational(faker.bool().bool());
        setNetAmount(faker.number().randomDouble(12, 1, 10000000));
    }

    public PostRewardsRequestModel createPostRewardRequestModel() {
        generateData();
        getDates();

        return PostRewardsRequestModel.builder()
                .productType(productType)
                .method(method)
                .currency(currency)
                .netAmount(netAmount)
                .meta(
                        new PostRewardsMetaRequestModel(
                                couponCode,
                                origin,
                                destination,
                                airlineCode,
                                tripFrom,
                                tripTo,
                                productPriceTotal,
                                productPriceTax,
                                productPriceBase,
                                totalWithoutVat,
                                domestic,
                                international
                        )
                )
                .build();
    }
}