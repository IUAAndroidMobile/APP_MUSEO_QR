package com.iua.museum.item_detail.view

import android.os.Parcel
import android.os.Parcelable

data class ItemDetailViewInput(
    val publicId: Int
): Parcelable {
    constructor(parcel: Parcel) : this(parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(publicId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ItemDetailViewInput> {
        override fun createFromParcel(parcel: Parcel): ItemDetailViewInput {
            return ItemDetailViewInput(parcel)
        }

        override fun newArray(size: Int): Array<ItemDetailViewInput?> {
            return arrayOfNulls(size)
        }
    }
}
