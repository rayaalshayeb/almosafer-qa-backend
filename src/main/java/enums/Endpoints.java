package enums;

import lombok.Getter;


public enum Endpoints {
    getCurrency("/api/system/currency/list");

    @Getter
    private final String value;


    Endpoints(String value) {
        this.value = value;
    }

}


