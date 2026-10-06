package com.example.saturnus_dimasbudi.pert6.home

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import com.example.saturnus_dimasbudi.AuthActivity
import com.example.saturnus_dimasbudi.R
import com.example.saturnus_dimasbudi.pert10.TenthActivity
import com.example.saturnus_dimasbudi.pert11.EleventhActivity
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
        val listViewItems = view.findViewById<ListView>(R.id.listViewItems)

        // Setup Toolbar di dalam Fragment
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Home - Menu List"

        // Data untuk ListView (Simple Item dengan Judul & Deskripsi)
        val titles = arrayOf(
            "To Activity Second",
            "To Activity Fourth",
            "To Activity Fifth",
            "To Activity Sixth",
            "To Activity Tenth",
            "To Activity Eleventh",
            "Ke Web View MLB",
            "Logout"
        )

        val descriptions = arrayOf(
            "Pertemuan 2 - Belajar Kotlin & Toast",
            "Pertemuan 4 - Intent, CardView, Snackbar & Dialog",
            "Pertemuan 5 - Options Menu & Toolbar",
            "Pertemuan 6 - Fragment Navigation",
            "Pertemuan 10 - Custom UI, Chip & Material Input",
            "Pertemuan 11 - TabLayout & ViewPager2",
            "Berita Terkini Boston Red Sox",
            "Keluar dari Akun Saturnus Dimas Budi"
        )

        val listData = ArrayList<HashMap<String, String>>()
        for (i in titles.indices) {
            val map = HashMap<String, String>()
            map["title"] = titles[i]
            map["desc"] = descriptions[i]
            listData.add(map)
        }

        val adapter = object : SimpleAdapter(
            requireContext(),
            listData,
            android.R.layout.simple_list_item_2,
            arrayOf("title", "desc"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        ) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val itemView = super.getView(position, convertView, parent)
                val text1 = itemView.findViewById<TextView>(android.R.id.text1)
                val text2 = itemView.findViewById<TextView>(android.R.id.text2)

                text1?.setTextColor(Color.WHITE)
                text1?.textSize = 16f
                text1?.setTypeface(null, Typeface.BOLD)

                if (position == titles.size - 1) {
                    text1?.setTextColor(Color.parseColor("#BD3039"))
                }

                text2?.setTextColor(Color.parseColor("#8AB4F8"))
                text2?.textSize = 13f
                return itemView
            }
        }

        listViewItems.adapter = adapter

        // Event listener saat item pada ListView diklik
        listViewItems.setOnItemClickListener { _, _, position, _ ->
            when (position) {
                0 -> {
                    val intent = Intent(requireContext(), SecondActivity::class.java)
                    startActivity(intent)
                }
                1 -> {
                    val intent = Intent(requireContext(), FourthActivity::class.java)
                    startActivity(intent)
                }
                2 -> {
                    val intent = Intent(requireContext(), FifthActivity::class.java)
                    startActivity(intent)
                }
                3 -> {
                    val intent = Intent(requireContext(), SixthActivity::class.java)
                    startActivity(intent)
                }
                4 -> {
                    val intent = Intent(requireContext(), TenthActivity::class.java)
                    startActivity(intent)
                }
                5 -> {
                    val intent = Intent(requireContext(), EleventhActivity::class.java)
                    startActivity(intent)
                }
                6 -> {
                    val intent = Intent(requireContext(), WebViewActivity::class.java)
                    startActivity(intent)
                }
                7 -> {
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
    }
}
