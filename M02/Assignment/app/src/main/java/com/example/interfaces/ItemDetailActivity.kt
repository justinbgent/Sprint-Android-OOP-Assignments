package com.example.interfaces

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import com.example.interfaces.ItemDetailFragment.Companion.ARG_ITEM_ID
import com.example.interfaces.model.Vehicle
import kotlinx.android.synthetic.main.activity_item_detail.*

/**
 * An activity representing a single Item detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a [ItemListActivity].
 */
class ItemDetailActivity : AppCompatActivity(), ItemDetailFragment.ObtainWeight  {

    override fun getWeight(weight: Int) {
        Toast.makeText(this, "Weight: ${weight}lbs", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        setSupportActionBar(detail_toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own detail action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

//        TODO: This is just to make my added code easy to find
        if (savedInstanceState == null) {
            val fragment = ItemDetailFragment()
            val bundle = Bundle()
            val item = intent.getParcelableExtra<Parcelable>(ARG_ITEM_ID) as Vehicle?
            bundle.putParcelable(ARG_ITEM_ID, item)
            fragment.arguments = bundle

            supportFragmentManager.beginTransaction()
                .add(R.id.item_detail_container, fragment)
                .commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            android.R.id.home -> {
                // This ID represents the Home or Up button. In the case of this
                // activity, the Up button is shown. For
                // more details, see the Navigation pattern on Android Design:
                //
                // http://developer.android.com/design/patterns/navigation.html#up-vs-back

                navigateUpTo(Intent(this, ItemListActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
}
