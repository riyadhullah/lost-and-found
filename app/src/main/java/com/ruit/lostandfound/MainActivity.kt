package com.ruit.lostandfound

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val sys = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(sys.left, sys.top, sys.right, 0)
            insets
        }

        toolbar = findViewById(R.id.toolBar)
        setSupportActionBar(toolbar)

        // supportActionBar?.setDisplayHomeAsUpEnabled(true) //back button
        toolbar.subtitle = "Home"

        bottomNavigationView = findViewById(R.id.bottom_nav)

        replaceFragment(HomeFragment())

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_home -> {
                    replaceFragment(HomeFragment())
                    toolbar.subtitle = "Home"
                    true
                }
                R.id.action_search -> {
                    replaceFragment(SearchFragment())
                    toolbar.subtitle = "Search"
                    true
                }
                R.id.action_add -> {
                    replaceFragment(AddFragment())
                    toolbar.subtitle = "Add"
                    true
                }
                R.id.action_profile -> {
                    replaceFragment(LoginFragment())
                    toolbar.subtitle = "Profile"
                    true
                }
                else -> false
            }
        }


    }


    fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_help    -> {
                Toast.makeText(this, "Help clicked", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_about -> {
                Toast.makeText(this, "About clicked", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_logout ->{
                Toast.makeText(this, "Logout clicked", Toast.LENGTH_SHORT).show()

                true
            }
            else -> false
        }
    }
}
