package Almosafer;

import helpers.Seeder;
import models.PostRewardsRequestModel;
import models.PostRewardsResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import static helpers.ApiHelper.createReward;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CreateRewardsTest {
    Seeder seeder = new Seeder();

    @Test
    @DisplayName("Success create reward.")
    public void successfulCreateReward() {
        PostRewardsRequestModel postRewardsRequestModel = seeder.createPostRewardRequestModel();

        PostRewardsResponseModel response = step("Perform create reward request", () ->
                createReward(postRewardsRequestModel, 200));
        step("Verify successful create new reward", () ->
                assertThat(response.isSuccess()));
        step("Verify new reward data", () ->
                assertThat(response.getMeta().equals(postRewardsRequestModel.getMeta())));
        System.out.println(response);
    }

    @Test
    @DisplayName("Failed create reward with Qitaf method and None SAR currency.")
    public void failedCreateReward() {
        PostRewardsRequestModel postRewardsRequestModel = seeder.createPostRewardRequestModel();
        postRewardsRequestModel.setMethod("qitaf");
        postRewardsRequestModel.setCurrency("USD");

        PostRewardsResponseModel response = step("Perform create reward request", () ->
                createReward(postRewardsRequestModel, 400));
        step("Verify create new reward failed status", () ->
                assertThat(!response.isSuccess()));
        step("Verify create new reward failed message", () ->
                assertThat(response.getMessage().equals("Qitaf – currency: `currency` must be one of [SAR, sar].")));
        System.out.println(response);
    }

}
