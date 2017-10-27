package com.example.charles.makelistview.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by charles on 2017. 10. 27..
 * Datum
 */

public class Datum implements Parcelable {

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("name_image")
    @Expose
    private String nameImage;

    @SerializedName("count")
    @Expose
    private int count;

    @SerializedName("type")
    @Expose
    private String type;

    public final static Parcelable.Creator<Datum> CREATOR = new Creator<Datum>() {
        @Override
        public Datum createFromParcel(Parcel in) {
            Datum instance = new Datum();
            instance.image = (String)in.readValue(String.class.getClassLoader());
            instance.title = (String)in.readValue(String.class.getClassLoader());
            instance.name = (String)in.readValue(String.class.getClassLoader());
            instance.nameImage = (String)in.readValue(String.class.getClassLoader());
            instance.count = (int)in.readValue(int.class.getClassLoader());
            instance.type = (String)in.readValue(String.class.getClassLoader());
            return instance;
        }

        @Override
        public Datum[] newArray(int size) {
            return new Datum[size];
        }
    };

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameImage() {
        return nameImage;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(image);
        dest.writeValue(title);
        dest.writeValue(name);
        dest.writeValue(nameImage);
        dest.writeValue(count);
        dest.writeValue(type);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
