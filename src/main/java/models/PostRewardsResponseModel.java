package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostRewardsResponseModel {
    public String provider;
    public int code;
    public String message;
    @JsonProperty("isSuccess")
    public boolean success;
    public String connectionId;
    public String requestId;
    public double amount;
    public String currency;
    public Date requestDate;
    public int rewardType;
    public int rewardValue;
    public PostRewardsMetaResponseModel meta;
    public PostRewardsRuleResponseModel rule;

}
