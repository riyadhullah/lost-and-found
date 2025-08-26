package com.ruit.lostandfound

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.bottomsheet.BottomSheetDialog


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnSeeAll = view.findViewById<Button>(R.id.btnSeeAll)

        btnSeeAll.setOnClickListener {
            Snackbar.make(view, "Total lost items 3", Snackbar.LENGTH_SHORT).show()
        }

        val rv = view.findViewById<RecyclerView>(R.id.recyclerView)
        rv.layoutManager = LinearLayoutManager(requireContext())


        val demoCards = listOf(
            CardDataClass("Wallet", "Library", "20 Aug 2025", R.drawable.wallet),
            CardDataClass("Watch", "Cafeteria", "19 Aug 2025", R.drawable.watch),
            CardDataClass("Book", "Room 3208", "18 Aug 2025", R.drawable.book)
        )

        rv.adapter = CardAdapterClass(
            demoCards,
            onClaimClick = { item ->
                Toast.makeText(requireContext(), "Claim: ${item.itemName}", Toast.LENGTH_SHORT).show()
            },
            onImageClick = { item ->
                showItemDetailsBottomSheet(item)
            }
        )
    }

    private fun showItemDetailsBottomSheet(item: CardDataClass) {
        val dialog = BottomSheetDialog(requireContext())
        val content = layoutInflater.inflate(R.layout.bottom_sheet_item_details, null)

        val photo = content.findViewById<ImageView>(R.id.photo)
        val title = content.findViewById<TextView>(R.id.title)
        val location = content.findViewById<TextView>(R.id.location)
        val date = content.findViewById<TextView>(R.id.date)

        photo.setImageResource(item.itemImage)
        title.text = item.itemName
        location.text = "Location: ${item.itemLocation}"
        date.text = "Date: ${item.itemDate}"


        dialog.setContentView(content)
        dialog.show()
    }


}