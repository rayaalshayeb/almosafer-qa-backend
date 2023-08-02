package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;


@Data
@Builder
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostRewardsRequestModel {
    public String productType;
    public String currency;
    public String method;
    public double netAmount;
    public PostRewardsMetaRequestModel meta;

}
