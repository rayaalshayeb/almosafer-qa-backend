package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetCurrencyResponseModel {


        public static String symbol;
        public static String name;
        public static String name_ar;
        public static String symbol_native;
        public static int decimal_digits;
        public static int rounding;
        public static String code;
        public static String name_plural;
        public static double rate;
        @JsonProperty("Rate")
        public static double rate2;
        public static String date;



}
