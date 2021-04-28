package com.example.test2.activityThree.ui

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test2.R
import com.example.test2.activityThree.ui.vm.ActivityThreeViewModel
import com.example.test2.activityThree.ui.vm.CustomViewModelFactory
import com.example.test2.data.datasource.ItemListDatabase
import com.example.test2.data.datasource.ProductListRepository
import com.example.test2.data.datasource.room.RoomItemsListDataSource
import kotlinx.android.synthetic.main.activity_three.*


class ActivityThree : AppCompatActivity() {


    private lateinit var repository: ProductListRepository

    lateinit var viewModel: ActivityThreeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three)
        initRecyclerView()
        val roomDatabase = ItemListDatabase.getDatabase(this)
        val dataSource = RoomItemsListDataSource(roomDatabase)
        repository = ProductListRepository(dataSource)
        initViewModel()

        btn_fab.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this)

            val inflater = layoutInflater
            val dialogLayout = inflater.inflate(R.layout.edit_text_alert_dialog, null)

            val editTextURL = dialogLayout.findViewById<EditText>(R.id.edt_url)
            val editTextDescription = dialogLayout.findViewById<EditText>(R.id.edt_description)

            with(alertDialog) {
                setTitle("Add Element")
                setPositiveButton("Ок") { _: DialogInterface, _: Int ->
                    val imageURL = editTextURL.text.toString()
                    val item = editTextDescription.text.toString()
                    viewModel.createItem(imageURL, item)
                }
                setNegativeButton("Отмена") { _: DialogInterface, _: Int ->
                }
                setView(dialogLayout)
            }
            alertDialog.show()
        }
    }

    private fun initRecyclerView() {
        rv_recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(
            this,
            CustomViewModelFactory(repository)
        ).get(ActivityThreeViewModel::class.java)
        val recyclerAdapter = ActivityThreeAdapter()

        rv_recycler.adapter = recyclerAdapter

        viewModel.items.observe(this) {
            recyclerAdapter.setItems(it)
            recyclerAdapter.notifyDataSetChanged()
        }

    }
}
