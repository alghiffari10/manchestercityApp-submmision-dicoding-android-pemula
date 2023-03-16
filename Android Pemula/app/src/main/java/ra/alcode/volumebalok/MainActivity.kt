package ra.alcode.volumebalok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import ra.alcode.volumebalok.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
//    private lateinit var edtWidth: EditText
//    private lateinit var edtLength: EditText
//    private lateinit var edtHeight: EditText
//    private lateinit var btnCalculate: Button
//    private lateinit var tvResult : TextView
    private lateinit var binding: ActivityMainBinding


    companion object{
        private const val STATE_RESULT = "state_result"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT,binding.tvResult.text.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        edtWidth = findViewById(R.id.edt_lebar)
//        edtHeight = findViewById(R.id.edt_tinggi)
//        edtLength = findViewById(R.id.edt_panjang)
//        btnCalculate = findViewById(R.id.btn_hitung)
//        tvResult = findViewById(R.id.tv_result)


        binding.btnHitung.setOnClickListener(this)

        if (savedInstanceState != null){
            val result = savedInstanceState.getString(STATE_RESULT)
            binding.tvResult.text = result
        }


    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.btn_hitung){
            val inputLength = binding.edtPanjang.text.toString().trim()
            val inputWidth = binding.edtLebar.text.toString().trim()
            val inputHeight = binding.edtTinggi.text.toString().trim()

            var isEmptyFields = false

            if(inputLength.isEmpty()){
                isEmptyFields = true
                binding.edtPanjang.error = "Field ini tidak boleh kosong"
            }else if(inputWidth.isEmpty()){
                isEmptyFields = true
                binding.edtLebar.error = "Field ini tidak boleh kosong"
            }else if(inputHeight.isEmpty()){
                isEmptyFields = true
                binding.edtTinggi.error = "Field ini tidak boleh kosong"
            }
            if(!isEmptyFields){
                val volume = inputHeight.toDouble() * inputLength.toDouble() * inputWidth.toDouble()
                binding.tvResult.text = volume.toString()
            }
        }

    }
}