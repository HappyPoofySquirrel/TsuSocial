package com.guvyerhopkins.tsusocial.core
import com.google.gson.annotations.SerializedName

data class MockUserResult(
    @SerializedName("data")
    val `data`: Data
)

data class Data(
    @SerializedName("users")
    val users: List<MockUser>
)

data class MockUser(
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("profile_picture_url")
    val profilePictureUrl: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("verified_status")
    private val verifiedStatus: Int
) {
    fun getVerifiedStatus(): String {
        return if (verifiedStatus == 1) {
            "Verified"
        } else {
            "Not Verified"
        }
    }
}