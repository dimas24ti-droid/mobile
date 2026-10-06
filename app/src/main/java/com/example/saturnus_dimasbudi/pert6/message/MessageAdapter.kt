package com.example.saturnus_dimasbudi.pert6.message

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.saturnus_dimasbudi.R
import com.example.saturnus_dimasbudi.databinding.ItemMessageBinding
import com.google.android.material.snackbar.Snackbar

class MessageAdapter(
    context: Context,
    private val messages: List<MessageModel>
) : ArrayAdapter<MessageModel>(context, 0, messages) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ItemMessageBinding = ItemMessageBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        val view = binding.root

        val message = messages[position]

        // Memuat avatarUrl dengan Glide
        Glide.with(context)
            .load(message.avatarUrl)
            .circleCrop()
            .placeholder(R.drawable.red)
            .error(R.drawable.red)
            .into(binding.avatarImg)

        binding.textSender.text = message.senderName
        binding.textMessage.text = message.messageText
        binding.textUsia.text = "${message.usia} Thn"

        view.setOnClickListener {
            Snackbar.make(
                parent,
                "Pesan dari ${message.senderName} (${message.usia} thn): ${message.messageText}",
                Snackbar.LENGTH_SHORT
            ).show()
        }

        return view
    }
}
