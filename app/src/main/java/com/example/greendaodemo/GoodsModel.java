package com.example.greendaodemo;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;

/**
 * author : lwz
 * date : 2022/10/26 16:30
 * desc :
 * version: 1.0
 */
@Entity
public class GoodsModel implements Parcelable {
    @Id(autoincrement = true)
    private Long id;
    @Index(unique = true)
    private Integer goodsId;
    private String name;
    private String icon;
    private String info;
    private String type;

    protected GoodsModel(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        if (in.readByte() == 0) {
            goodsId = null;
        } else {
            goodsId = in.readInt();
        }
        name = in.readString();
        icon = in.readString();
        info = in.readString();
        type = in.readString();
    }

    @Generated(hash = 1834473137)
    public GoodsModel(Long id, Integer goodsId, String name, String icon,
            String info, String type) {
        this.id = id;
        this.goodsId = goodsId;
        this.name = name;
        this.icon = icon;
        this.info = info;
        this.type = type;
    }

    @Generated(hash = 971639536)
    public GoodsModel() {
    }

    public static final Creator<GoodsModel> CREATOR = new Creator<GoodsModel>() {
        @Override
        public GoodsModel createFromParcel(Parcel in) {
            return new GoodsModel(in);
        }

        @Override
        public GoodsModel[] newArray(int size) {
            return new GoodsModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(id);
        }
        if (goodsId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(goodsId);
        }
        parcel.writeString(name);
        parcel.writeString(icon);
        parcel.writeString(info);
        parcel.writeString(type);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return this.goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}