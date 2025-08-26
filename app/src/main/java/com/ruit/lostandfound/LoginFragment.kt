package com.ruit.lostandfound

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class LoginFragment : Fragment() {

    private lateinit var username: EditText
    private lateinit var sharedPreference: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        username = view.findViewById(R.id.username)
        val btnLogin = view.findViewById<Button>(R.id.btnLogin)


        sharedPreference = requireContext().getSharedPreferences("myData", Context.MODE_PRIVATE)



        btnLogin.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.frame, ProfileFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onResume() {
        super.onResume()
        writeData()
    }

    override fun onPause() {
        super.onPause()
        saveData()
    }

    private fun saveData() {
        val edit = sharedPreference.edit()

        edit.putString("username", username.text.toString())
            .apply()
    }

    private fun writeData() {
        username.setText(sharedPreference.getString("username", ""))
    }
}
