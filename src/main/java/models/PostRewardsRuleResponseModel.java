package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostRewardsRuleResponseModel {
    public int rewardFactor;
    public String rewardFactorMethod;
    public int rewardMultiplier;
    public int netAmount;
    public String ruleId;
}

