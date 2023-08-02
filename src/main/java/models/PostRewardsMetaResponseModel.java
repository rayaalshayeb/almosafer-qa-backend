package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.Date;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostRewardsMetaResponseModel {
    public String couponCode;
    public boolean isDomestic;
    public boolean isInternational;
    public String origin;
    public String destination;
    public String airlineCode;
    public String tripFrom;
    public String tripTo;
    public int productPriceTotal;
    public int productPriceTax;
    public int productPriceBase;
    public int totalWithoutVat;

}


