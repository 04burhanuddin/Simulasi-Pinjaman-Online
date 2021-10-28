package id.susilo.joko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //proses perhitungan
    fun _Hitung(view: View){
        //format hasil perhitungan ke rupiah
        val formater = NumberFormat.getCurrencyInstance(Locale("in", "id"))

        //id input dan output pada layout xml
        val _inputPinjam = findViewById<EditText>(R.id.input_pinjaman)
        val _inputTenor = findViewById<EditText>(R.id.input_tenor)
        val _pencairan = findViewById<TextView>(R.id._pencairan)
        val _totalPinjam = findViewById<TextView>(R.id._pembayaran)

        // data
        val _sukuBunga = 3.75/100 //berdasarkan kasus pada soal

        //perhitungan
        val _tenor = _sukuBunga * _inputTenor.text.toString().toDouble()
        val _penciran = _inputPinjam.text.toString().toDouble() * 5/100
        val _pencairanBersih = _inputPinjam.text.toString().toDouble() - _penciran.toString().toDouble()
        val _totalPinjaman = _inputPinjam.text.toString().toDouble() + _tenor.toString().toDouble()

        //menampilkan total pencairan
        val _totalPencairan = formater.format(_pencairanBersih.toString().toDouble())
        _pencairan.text = _totalPencairan

        //menampilkan total pembayaran
        val _totalPembayaran = formater.format(_totalPinjaman.toString().toDouble())
        _totalPinjam.text = _totalPembayaran


    }
}