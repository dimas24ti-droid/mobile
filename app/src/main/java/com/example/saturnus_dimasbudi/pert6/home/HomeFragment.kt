package com.example.saturnus_dimasbudi.pert6.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import com.example.saturnus_dimasbudi.AuthActivity
import com.example.saturnus_dimasbudi.R
import com.example.saturnus_dimasbudi.pert2.SecondActivity
import com.example.saturnus_dimasbudi.pert4.FourthActivity
import com.example.saturnus_dimasbudi.pert5.FifthActivity
import com.example.saturnus_dimasbudi.pert5.WebViewActivity
import com.example.saturnus_dimasbudi.pert6.SixthActivity

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        val btnToSecond = view.findViewById<Button>(R.id.btnToSecond)
        val btnToFourth = view.findViewById<Button>(R.id.btnToFourth)
        val btnToFifth = view.findViewById<Button>(R.id.btnToFifth)
        val btnToSixth = view.findViewById<Button>(R.id.btnToSixth)
        val btnToWebView = view.findViewById<Button>(R.id.btnToWebView)
        val btnLogout = view.findViewById<Button>(R.id.btnLogout)

        // Setup Toolbar di dalam Fragment
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Home"

        // Event listener ke activity lain
        btnToSecond?.setOnClickListener {
            val intent = Intent(requireContext(), SecondActivity::class.java)
            startActivity(intent)
        }

        btnToFourth?.setOnClickListener {
            val intent = Intent(requireContext(), FourthActivity::class.java)
            startActivity(intent)
        }

        btnToFifth?.setOnClickListener {
            val intent = Intent(requireContext(), FifthActivity::class.java)
            startActivity(intent)
        }

        btnToSixth?.setOnClickListener {
            val intent = Intent(requireContext(), SixthActivity::class.java)
            startActivity(intent)
        }

        btnToWebView?.setOnClickListener {
            val intent = Intent(requireContext(), WebViewActivity::class.java)
            startActivity(intent)
        }

        // Event Logout
        btnLogout?.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Konfirmasi Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val sharedPref = requireContext().getSharedPreferences("user_pref", Context.MODE_PRIVATE)
                    sharedPref.edit {
                        clear()
                    }

                    dialog.dismiss()

                    val intent = Intent(requireContext(), AuthActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    requireActivity().finish()
                }
                .setNegativeButton("Tidak", null)
                .show()
        }
    }
}
