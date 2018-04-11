package com.example.oso.timmon.data.remote;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "https://rest-apis-194315.appspot.com/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}