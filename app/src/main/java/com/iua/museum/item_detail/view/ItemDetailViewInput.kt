package com.iua.museum.item_detail.view

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemDetailViewInput(
    val publicId: String
): Parcelable
