package com.example.saturnus_dimasbudi.pert6.more

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.saturnus_dimasbudi.R

class MoreFragment : Fragment() {

    private val dataListWithDesc = listOf(
        mapOf("title" to "Kotlin", "desc" to "Bahasa untuk Android modern"),
        mapOf("title" to "Java", "desc" to "Bahasa OOP yang populer"),
        mapOf("title" to "Python", "desc" to "Bahasa yang mudah dipahami"),
        mapOf("title" to "C++", "desc" to "Bahasa tingkat tinggi untuk performa tinggi"),
        mapOf("title" to "JavaScript", "desc" to "Bahasa utama untuk pengembangan web"),
        mapOf("title" to "Dart", "desc" to "Bahasa yang digunakan oleh Flutter"),
        mapOf("title" to "Swift", "desc" to "Bahasa utama untuk pengembangan iOS/macOS"),
        mapOf("title" to "Go", "desc" to "Bahasa efisien dari Google untuk backend"),
        mapOf("title" to "Ruby", "desc" to "Bahasa dinamis yang fokus pada kesederhanaan"),
        mapOf("title" to "PHP", "desc" to "Bahasa skrip server-side untuk web"),
        mapOf("title" to "C#", "desc" to "Bahasa buatan Microsoft untuk .NET & Game Dev"),
        mapOf("title" to "TypeScript", "desc" to "Superset dari JavaScript dengan tipe data ketat"),
        mapOf("title" to "SQL", "desc" to "Bahasa kueri untuk mengelola database relasional"),
        mapOf("title" to "Rust", "desc" to "Bahasa sistem dengan keamanan memori tanpa GC"),
        mapOf("title" to "HTML & CSS", "desc" to "Bahasa struktur & gaya untuk tampilan web")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_more, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        val listViewItems = view.findViewById<ListView>(R.id.listViewItems)

        // Setup Toolbar di dalam Fragment
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "More - Programming Languages"

        // Adapter SimpleAdapter dengan layout default android.R.layout.simple_list_item_2
        val adapter = object : SimpleAdapter(
            requireContext(),
            dataListWithDesc,
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

                text2?.setTextColor(Color.parseColor("#8AB4F8"))
                text2?.textSize = 13f
                return itemView
            }
        }

        listViewItems.adapter = adapter

        // Aksi saat item pada ListView diklik
        listViewItems.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = dataListWithDesc[position]
            val title = selectedItem["title"]
            val desc = selectedItem["desc"]
            Toast.makeText(requireContext(), "Kamu memilih: $title ($desc)", Toast.LENGTH_SHORT).show()
        }
    }
}
