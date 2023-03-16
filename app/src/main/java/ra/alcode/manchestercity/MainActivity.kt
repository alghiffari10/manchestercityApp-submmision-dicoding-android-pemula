package ra.alcode.manchestercity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class MainActivity : AppCompatActivity() {
    private lateinit var rvPlayer : RecyclerView
    private val list = ArrayList<Player>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPlayer = findViewById(R.id.rv_player)
        rvPlayer.setHasFixedSize(true)
        val profileBtn : CircleImageView = findViewById(R.id.profile_btn)
        profileBtn.setOnClickListener {
            val toAbout = Intent(this@MainActivity,AboutActivity::class.java)
            startActivity(toAbout)
        }

        list.addAll(getListHero())
        showRecyclerList()


    }
    private fun showSelectedHero(player: Player) {
        val toDetail = Intent(this@MainActivity, DetailActivity::class.java)
        toDetail.putExtra(DetailActivity.EXTRA_PLAYER,player)
        startActivity(toDetail)

    }

    private fun showRecyclerList() {
        rvPlayer.layoutManager = GridLayoutManager(this,2)
        val listPlayerAdapter = ListPlayerAdapter(list)
        rvPlayer.adapter = listPlayerAdapter

        listPlayerAdapter.setOnItemClickCallback(object :ListPlayerAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Player) {
                showSelectedHero(data)
            }
        })
    }

    private fun getListHero(): ArrayList<Player> {
        val dataName = resources.getStringArray(R.array.player_name)
        val dataShirtNumber = resources.getStringArray(R.array.player_shirt_number)
        val dataPosition = resources.getStringArray(R.array.position)
        val dataPhoto = resources.getStringArray(R.array.player_photo)
        val dataMatch = resources.getStringArray(R.array.player_game)
        val dataMinute = resources.getStringArray(R.array.player_minute)
        val dataGoal = resources.getStringArray(R.array.player_goal)
        val dataAssists = resources.getStringArray(R.array.player_assists)
        val dataWeight = resources.getStringArray(R.array.player_weight)
        val dataHeight = resources.getStringArray(R.array.player_height)
        val dataAge = resources.getStringArray(R.array.player_age)
        val dataBio = resources.getStringArray(R.array.player_bio)

        val listHero = ArrayList<Player>()
        for (i in dataName.indices){
            val player = Player(dataName[i],dataShirtNumber[i],dataPosition[i],dataPhoto[i],dataMatch[i],dataMinute[i],dataGoal[i],dataAssists[i],dataWeight[i],dataHeight[i],dataAge[i],dataBio[i])
            listHero.add(player)
        }
        return listHero
    }


}