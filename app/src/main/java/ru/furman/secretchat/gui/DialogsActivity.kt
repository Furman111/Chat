package ru.furman.secretchat.gui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_dialogs.*
import org.jetbrains.anko.toast
import ru.furman.secretchat.R
import ru.furman.secretchat.model.ui.DialogUI

class DialogsActivity : AppCompatActivity() {

    private lateinit var dialogsAdapter: DialogsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialogs)

        addDialogFAB.setOnClickListener {
            toast("Going to screen of adding new Dialog")
        }

        val dialogs = List(20) {
            DialogUI(
                    System.currentTimeMillis() + (it % 2) * 24 * 60 * 60 * 1000L,
                    "Wow Wow $it",
                    "Bla bla bla $it"
            )
        }

        dialogsAdapter = DialogsAdapter(dialogs) {
            toast("going to dialog with ${it.name}")
        }
        with(dialogsRecycler) {
            adapter = dialogsAdapter
            layoutManager = LinearLayoutManager(context)
        }

    }

}
