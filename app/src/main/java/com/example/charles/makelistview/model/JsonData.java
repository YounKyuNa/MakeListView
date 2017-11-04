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
        public JsonData createFromParcel(Parcel in) {
            JsonData instance = new JsonData();
            in.readList(instance.popular, Popular.class.getClassLoader());
            in.readList(instance.data, Datum.class.getClassLoader());
            instance.status = (int)in.readValue(int.class.getClassLoader());
            instance.paginator = (Paginator) in.readValue(Paginator.class.getClassLoader());
            return instance;
        }

        @Override
        public JsonData[] newArray(int size) {
            return new JsonData[size];
        }
    };

    public List<Popular> getPopular() {
        return popular;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(popular);
        dest.writeList(data);
        dest.writeValue(status);
        dest.writeValue(paginator);
    }
}
