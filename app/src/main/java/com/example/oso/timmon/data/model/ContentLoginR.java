
package com.example.oso.timmon.data.model;

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class ContentLoginR {
    @Override
    public String toString() {
        return "ContentLoginR{" +
                "token='" + token + '\'' +
                ", data=" + data.toString() +
                '}';
    }

    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("data")
    @Expose
    private DataLoginXR data;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public DataLoginXR getData() {
        return data;
    }

    public void setData(DataLoginXR data) {
        this.data = data;
    }

}