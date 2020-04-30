package com.example.appmycontacts

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Switch
import kotlinx.android.synthetic.main.activity_contact.*

class ContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
    }

    //ctrl+o
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.contact_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        saveContact()
        return super.onOptionsItemSelected(item)
    }

    private fun saveContact() {
        val name = etName.text.toString()
        val telephone = etTelephone.text.toString()

        val intent = Intent()

        //metodos putExtra
        intent.putExtra("keyName", name)
        intent.putExtra("keyTelephone", telephone)

        setResult(Activity.RESULT_OK,intent)
        finish()
    }
}
