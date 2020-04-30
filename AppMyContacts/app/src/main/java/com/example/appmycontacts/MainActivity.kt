package com.example.appmycontacts

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    var REQUEST_CODE = 1
    var contacts = ArrayList<Contact>()
    var contactAdapter = ContactAdapter(contacts)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadContacts()
        initView()

        var itemTouchHelper = ItemTouchHelper(SwipeToDelete(contactAdapter))
        itemTouchHelper.attachToRecyclerView(rvContact)

    }

    fun initView() {
        rvContact.adapter = contactAdapter
        rvContact.layoutManager = LinearLayoutManager(this)
    }

    fun loadContacts() {
        contacts.add(Contact("Andre","952252313"))
        contacts.add(Contact("Takeshi","0034642364701"))
        contacts.add(Contact("Diana","916289904"))
    }

    //ctrl+O me muestra todos los override members
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val intent = Intent(this,ContactActivity::class.java)
        //ojo startActivity(intent)

        startActivityForResult(intent, REQUEST_CODE)

        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK){
                val name = data!!.getStringExtra("keyName")
                val telephone = data!!.getStringExtra("keyTelephone")

                val contact = Contact(name,telephone)
                contacts.add(contact)
            }
        }
    }
}