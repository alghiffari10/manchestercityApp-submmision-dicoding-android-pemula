package ra.alcode.manchestercity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Player(
    val name: String,
    val shirt_number : String,
    val position : String,
    val photo : String,
    val match : String,
    val minute: String,
    val goal: String,
    val assists : String,
    val weight : String,
    val height : String,
    val age : String,
    val bio : String,

): Parcelable
