package com.ecoandrich.maycodingTest.API.CoinAPI._Common.Constant;

public enum UpBitTickerApiInformation {

    ALL_CRYPTO_INFO_URL("https://api.upbit.com/v1/market/"),
    CRYPTO_DETAIL_INFO_URL("https://api.upbit.com/v1/ticker?markets=");

    private final String info;

    UpBitTickerApiInformation(String info) {
        this.info = info;
    }
}
