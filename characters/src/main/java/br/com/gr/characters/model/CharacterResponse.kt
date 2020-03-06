package br.com.gr.characters.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterResponse(
    @SerializedName("birthday")
    override val birthday: String,
    @SerializedName("category")
    override val category: String,
    @SerializedName("char_id")
    override val charId: Int,
    @SerializedName("img")
    override val img: String,
    @SerializedName("name")
    override val name: String,
    @SerializedName("nickname")
    override val nickname: String,
    @SerializedName("occupation")
    override val occupation: List<String>,
    @SerializedName("portrayed")
    override val portrayed: String,
    @SerializedName("status")
    override val status: String
) : Character, Parcelable