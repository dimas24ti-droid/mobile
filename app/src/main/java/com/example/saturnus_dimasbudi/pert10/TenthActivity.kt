package com.example.saturnus_dimasbudi.pert10

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.saturnus_dimasbudi.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class TenthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tenth)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val textInputLayout = findViewById<TextInputLayout>(R.id.textInputLayout)
        val etEmail = findViewById<TextInputEditText>(R.id.etEmail)
        val btnLogin = findViewById<MaterialButton>(R.id.btnLogin)
        val chipGroupFilter = findViewById<ChipGroup>(R.id.chipGroupFilter)
        val etCustomBorder = findViewById<EditText>(R.id.etCustomBorder)

        val btnMenu1 = findViewById<Button>(R.id.btnMenu1)
        val btnMenu2 = findViewById<Button>(R.id.btnMenu2)
        val btnMenu3 = findViewById<Button>(R.id.btnMenu3)
        val btnMenu4 = findViewById<Button>(R.id.btnMenu4)
        val btnMenu5 = findViewById<Button>(R.id.btnMenu5)
        val btnMenu6 = findViewById<Button>(R.id.btnMenu6)

        // Setup Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            title = "Pertemuan 10 - Material UI"
            setDisplayHomeAsUpEnabled(true)
        }
        toolbar.setNavigationOnClickListener { finish() }

        // ChipGroup Selection Listener
        chipGroupFilter.setOnCheckedStateChangeListener { group, checkedIds ->
            val selectedChipId = checkedIds.firstOrNull()
            if (selectedChipId != null) {
                val chip = group.findViewById<Chip>(selectedChipId)
                Toast.makeText(this, "Filter Dipilih: ${chip?.text}", Toast.LENGTH_SHORT).show()
            }
        }

        // Login Button Listener
        btnLogin.setOnClickListener {
            val email = etEmail.text?.toString()?.trim().orEmpty()
            if (email.isEmpty()) {
                textInputLayout.error = "Alamat Email tidak boleh kosong"
            } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                textInputLayout.error = "Format email tidak valid (contoh: user@mail.com)"
            } else {
                textInputLayout.error = null
                val notes = etCustomBorder.text?.toString()?.trim().orEmpty()
                val notesInfo = if (notes.isNotEmpty()) " | Catatan: $notes" else ""
                Snackbar.make(bindingRootView(), "Login Berhasil: $email$notesInfo", Snackbar.LENGTH_LONG).show()
            }
        }

        // Grid Menu Click Listeners
        btnMenu1.setOnClickListener { Toast.makeText(this, "Menu Home Diklik", Toast.LENGTH_SHORT).show() }
        btnMenu2.setOnClickListener { Toast.makeText(this, "Menu Pesan Diklik", Toast.LENGTH_SHORT).show() }
        btnMenu3.setOnClickListener { Toast.makeText(this, "Menu Favorit Diklik", Toast.LENGTH_SHORT).show() }
        btnMenu4.setOnClickListener { Toast.makeText(this, "Menu Info Diklik", Toast.LENGTH_SHORT).show() }
        btnMenu5.setOnClickListener { Toast.makeText(this, "Menu Setelan Diklik", Toast.LENGTH_SHORT).show() }
        btnMenu6.setOnClickListener { Toast.makeText(this, "Menu Notif Diklik", Toast.LENGTH_SHORT).show() }
    }

    private fun bindingRootView(): android.view.View {
        return findViewById(R.id.main)
    }
}
