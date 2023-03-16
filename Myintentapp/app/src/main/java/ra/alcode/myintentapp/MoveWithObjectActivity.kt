package ra.alcode.myintentapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithObjectActivity : AppCompatActivity() {

    companion object{
        const val  EXTRA_PERSON = "extra_person"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        val tvObjectReceiver :TextView = findViewById(R.id.tv_object_receiver)

        val person = if(Build.VERSION.SDK_INT >= 35){
            intent.getParcelableExtra<Person>(EXTRA_PERSON )
        }else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_PERSON)
        }

        if (person != null){
            val text = "Name : ${person.name.toString()},\nEmail : ${person.email},\nAge : ${person.age},\nLocation : ${person.city}"
            tvObjectReceiver.text = text
        }

    }
}