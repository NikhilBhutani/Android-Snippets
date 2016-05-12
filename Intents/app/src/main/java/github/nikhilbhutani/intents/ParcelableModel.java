package github.nikhilbhutani.intents;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Nikhil Bhutani on 5/12/2016.
 */
public class ParcelableModel implements Parcelable {

    private String name;
    private String address;


    public ParcelableModel(String name, String address)
    {

        this.name = name;
        this.address = address;
    }

    protected ParcelableModel(Parcel in) {
        name =in.readString();
        address = in.readString();

    }

    public static final Creator<ParcelableModel> CREATOR = new Creator<ParcelableModel>() {
        @Override
        public ParcelableModel createFromParcel(Parcel in) {

            return new ParcelableModel(in);
        }

        @Override
        public ParcelableModel[] newArray(int size) {
            return new ParcelableModel[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(address);
    }
}
