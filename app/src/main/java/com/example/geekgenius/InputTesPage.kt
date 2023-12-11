package com.example.geekgenius

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import com.example.geekgenius.databinding.ActivityInputTesPageBinding

class InputTesPage : AppCompatActivity() {
    private lateinit var btnTes: Button
    private lateinit var checkboxIds: MutableList<Int>
    private lateinit var kecerdasanName: Array<String>
    private lateinit var dataJurusan: Array<String>
    private lateinit var binding: ActivityInputTesPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityInputTesPageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        kecerdasanName = resources.getStringArray(R.array.kecerdasan_name)
        dataJurusan = resources.getStringArray(R.array.data_jurusan)

        checkboxIds = mutableListOf(R.id.F1, R.id.F2, R.id.F3, R.id.F4, R.id.F5, R.id.F6,
            R.id.F7, R.id.F8, R.id.F9, R.id.F10, R.id.F11, R.id.F12, R.id.F13, R.id.F14, R.id.F15, R.id.F16,
            R.id.F17, R.id.F18, R.id.F19, R.id.F20, R.id.F21, R.id.F22, R.id.F23, R.id.F24, R.id.F25, R.id.F26,
            R.id.F27, R.id.F28, R.id.F29, R.id.F30, R.id.F31, R.id.F32,
            R.id.F33, R.id.F34, R.id.F35, R.id.F36, R.id.F37, R.id.F38,
            R.id.F39, R.id.F40, R.id.F41, R.id.F42, R.id.F43, R.id.F44,
            R.id.F45, R.id.F46, R.id.F47, R.id.F48, R.id.F49, R.id.F50,
            R.id.F51, R.id.F52, R.id.F53, R.id.F54, R.id.F55, R.id.F56,
            R.id.F57, R.id.F58, R.id.F59, R.id.F60, R.id.F61, R.id.F62,
            R.id.F63, R.id.F64, R.id.F65, R.id.F66, R.id.F67, R.id.F68,
            R.id.F69, R.id.F70, R.id.F71, R.id.F72, R.id.F73, R.id.F74,
            R.id.F75, R.id.F76, R.id.F77, R.id.F78, R.id.F79, R.id.F80)

        btnTes = findViewById(R.id.btnTes)
        btnTes.setOnClickListener {
            val intent = Intent(this@InputTesPage, HasilTesPage::class.java)

            // Menghitung nilai setiap kelompok
            val nilaiKelompok = hitungNilaiKelompok()

            // Mendapatkan kelompok dengan jumlah terbanyak
            val kelompokTerbanyak = cariKelompokTerbanyak(nilaiKelompok)

            val kelompokTerbanyakInt = kelompokTerbanyak?.toIntOrNull() ?: 0

            val index = if (kelompokTerbanyakInt in 1..kecerdasanName.size) kelompokTerbanyakInt - 1 else 0

            val kecerdasan = if (index >= 0) kecerdasanName[index] else ""
            val jurusan = if (index >= 0) dataJurusan[index] else ""

            intent.putExtra("KECERDASAN", kecerdasan)
            intent.putExtra("JURUSAN", jurusan)

            startActivity(intent)

        }
        binding.btnBack.setOnClickListener{
            finish()
        }
    }

    private fun hitungNilaiKelompok(): Map<String, Int> {
        val nilaiKelompok = mutableMapOf(
            "A1" to 0,
            "A2" to 0,
            "A3" to 0,
            "A4" to 0,
            "A5" to 0,
            "A6" to 0,
            "A7" to 0,
            "A8" to 0
        )

        for (i in 0 until 8) {
            val nilai = hitungNilaiKelompokTertentu(i)
            val key = "A${i + 1}"
            nilaiKelompok[key] = nilai
        }
        return nilaiKelompok
    }

    private fun hitungNilaiKelompokTertentu(index: Int): Int {
        var nilai = 0
        val startIndex = index * 10
        val endIndex = startIndex + 10
        for (i in startIndex until endIndex) {
            val checkbox = findViewById<CheckBox>(checkboxIds[i])
            if (checkbox.isChecked) {
                nilai++
            }
        }
        return nilai
    }

    private fun cariKelompokTerbanyak(nilaiKelompok: Map<String, Int>): String? {
        var kelompokTerbanyak: String? = null
        var nilaiTerbanyak = 0

        for ((kelompok, nilai) in nilaiKelompok) {
            if (nilai > nilaiTerbanyak) {
                nilaiTerbanyak = nilai
                kelompokTerbanyak = kelompok
            }
        }
        return kelompokTerbanyak
    }

}
