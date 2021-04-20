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
    val verifiedStatus: Int
)