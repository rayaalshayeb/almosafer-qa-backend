package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;


@Data
@AllArgsConstructor
@Builder
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostRewardsMetaRequestModel {
    public String couponCode;
    public String origin;
    public String destination;
    public String airlineCode;
    public String tripFrom;
    public String tripTo;
    public int productPriceTotal;
    public int productPriceTax;
    public int productPriceBase;
    public int totalWithoutVat;
    @JsonProperty("isDomestic")
    boolean domestic;
    @JsonProperty("isInternational")
    boolean international;

}


