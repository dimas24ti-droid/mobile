package com.example.saturnus_dimasbudi.pert6.message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.saturnus_dimasbudi.R
import com.example.saturnus_dimasbudi.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {

    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    private val messageList = listOf(
        MessageModel(senderName = "Alya", messageText = "Halo! Apa kabar?", avatarUrl = "https://i.pravatar.cc/150?img=1", usia = "19"),
        MessageModel(senderName = "Budi", messageText = "Sudah makan?", avatarUrl = "https://i.pravatar.cc/150?img=2", usia = "18"),
        MessageModel(senderName = "Citra", messageText = "Jangan lupa tugasnya ya!", avatarUrl = "https://i.pravatar.cc/150?img=3", usia = "22"),
        MessageModel(senderName = "Dika", messageText = "Besok kita rapat jam 9", avatarUrl = "https://i.pravatar.cc/150?img=4", usia = "25"),
        MessageModel(senderName = "Eka", messageText = "Nice job kemarin!", avatarUrl = "https://i.pravatar.cc/150?img=5", usia = "19"),
        MessageModel(senderName = "Fajar", messageText = "Lagi ngapain?", avatarUrl = "https://i.pravatar.cc/150?img=6", usia = "29"),
        MessageModel(senderName = "Gita", messageText = "Boleh minta tolong?", avatarUrl = "https://i.pravatar.cc/150?img=7", usia = "25"),
        MessageModel(senderName = "Hana", messageText = "Lihat email ya", avatarUrl = "https://i.pravatar.cc/150?img=8", usia = "26"),
        MessageModel(senderName = "Irfan", messageText = "Oke noted", avatarUrl = "https://i.pravatar.cc/150?img=9", usia = "27"),
        MessageModel(senderName = "Joko", messageText = "Sampai jumpa besok", avatarUrl = "https://i.pravatar.cc/150?img=10", usia = "24")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Messages"

        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
