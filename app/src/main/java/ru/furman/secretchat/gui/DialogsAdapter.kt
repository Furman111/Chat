package ru.furman.secretchat.gui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import ru.furman.secretchat.R
import ru.furman.secretchat.model.ui.DialogUI
import ru.furman.secretchat.setDateOrTime

class DialogsAdapter(
        private val dialogs: List<DialogUI>,
        private val onClick: ((dialog: DialogUI) -> Unit)? = null
) : RecyclerView.Adapter<DialogsAdapter.DialogVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            DialogVH(LayoutInflater.from(parent.context).inflate(R.layout.dialog_item, parent, false))

    override fun getItemCount() = dialogs.count()

    override fun onBindViewHolder(holder: DialogVH, position: Int) {
        holder.bind(dialogs[position], onClick)
    }


    class DialogVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val dateTV = itemView.findViewById<TextView>(R.id.dateTV)
        private val nameTV = itemView.findViewById<TextView>(R.id.nameTV)
        private val messageTV = itemView.findViewById<TextView>(R.id.messageTV)
        private val container = itemView.findViewById<LinearLayout>(R.id.dialog_container)

        fun bind(dialog: DialogUI, onClick: ((dialog: DialogUI) -> Unit)?) {
            nameTV.text = dialog.name
            messageTV.text = dialog.lastMessage
            dateTV.setDateOrTime(dialog.time)
            container.setOnClickListener { onClick?.invoke(dialog) }
        }

    }

}