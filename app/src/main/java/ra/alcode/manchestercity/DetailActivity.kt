package ra.alcode.manchestercity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class DetailActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_PLAYER = "extra_player"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imgPhoto : ImageView = findViewById(R.id.tv_photo)
        val tvName : TextView = findViewById(R.id.tv_name)
        val tvNumber : TextView = findViewById(R.id.shirt_number_player)
        val tvPosition : TextView = findViewById(R.id.tv_position)
        val tvGame : TextView = findViewById(R.id.tv_game)
        val tvMinute : TextView = findViewById(R.id.tv_minute)
        val tvGoal : TextView = findViewById(R.id.tv_goal)
        val tvAssist : TextView = findViewById(R.id.tv_assists)
        val tvHeight : TextView = findViewById(R.id.tv_height)
        val tvWeight : TextView = findViewById(R.id.tv_weight)
        val tvAge : TextView = findViewById(R.id.tv_age)
        val tvBio : TextView = findViewById(R.id.tv_bio)
        val backBtn : ImageView = findViewById(R.id.back_btn)

        backBtn.setOnClickListener {
            onBackPressed()
        }

        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)

        if (player != null){
            Glide.with(this)
                .load(player.photo)
                .into(imgPhoto)
            val name = player.name
            tvName.text = name

            val number = player.shirt_number
            tvNumber.text = number

            val position = player.position
            tvPosition.text = position

            val game = player.match
            tvGame.text = game

            val minute = player.minute
            tvMinute.text = minute

            val goal = player.goal
            tvGoal.text = goal

            val assist = player.assists
            tvAssist.text = assist

            val height = player.height
            tvHeight.text = height

            val weight = player.weight
            tvWeight.text = weight

            val age = player.age
            tvAge.text = age

            val bio = player.bio
            tvBio.text = bio
        }
    }
}