package ra.alcode.manchestercity

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListPlayerAdapter(private val listPlayer : ArrayList<Player>) : RecyclerView.Adapter<ListPlayerAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback : OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback : OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName : TextView = itemView.findViewById(R.id.name_player)
        val tvShirtNumber : TextView = itemView.findViewById(R.id.shirt_number_player)
        val tvPosition : TextView = itemView.findViewById(R.id.position_player)
        val imgPhoto : ImageView = itemView.findViewById(R.id.image_player)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_player, parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, shirt_number,posisi,photo) = listPlayer[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.imgPhoto)
        holder.tvName.text = name
        holder.tvShirtNumber.text = shirt_number
        holder.tvPosition.text = posisi

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listPlayer[holder.adapterPosition]) }


    }

    override fun getItemCount(): Int = listPlayer.size

    interface OnItemClickCallback {
        fun onItemClicked(data: Player)
    }
}