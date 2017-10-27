package com.example.charles.makelistview.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by charles on 2017. 10. 27..
 * Json Data
 */

public class JsonData implements Parcelable {

    @SerializedName("popular")
    @Expose
    private List<Popular> popular = new ArrayList<>();

    @SerializedName("data")
    @Expose
    private List<Datum> data = new ArrayList<>();

    @SerializedName("status")
    @Expose
    private int status;

    @SerializedName("paginator")
    @Expose
    private Paginator paginator;

    public final static Parcelable.Creator<JsonData> CREATOR = new Creator<JsonData>() {
        @Override
        public JsonData createFromParcel(Parcel source) {
            return null;
        }

        @Override
        public JsonData[] newArray(int size) {
            return new JsonData[0];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
