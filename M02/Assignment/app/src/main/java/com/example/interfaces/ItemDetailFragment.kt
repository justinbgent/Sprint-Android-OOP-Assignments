package com.example.interfaces

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.interfaces.ItemListActivity.Companion.favorite
import com.example.interfaces.ItemListActivity.Companion.vehicles
import com.example.interfaces.ItemListActivity.Companion.weight
import kotlinx.android.synthetic.main.activity_item_detail.*
import kotlinx.android.synthetic.main.item_detail.view.*

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a [ItemListActivity]
 * in two-pane mode (on tablets) or a [ItemDetailActivity]
 * on handsets.
 */
class ItemDetailFragment : Fragment() {

    /**
     * The dummy content this fragment is presenting.
     */
//    private var itemId: Vehicle? = null
    private var itemId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
//                itemId = it.getSerializable(ARG_ITEM_ID) as Vehicle?
//                activity?.toolbar_layout?.let {layout ->
//                    layout.toolbar_layout.title = itemId?.id
//                }

                /*val id*/itemId = it.getString(ARG_ITEM_ID)
                activity?.toolbar_layout?.title = itemId ?: "Null"
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.item_detail, container, false)

        rootView.btn_more.setOnClickListener {
            objectWeight?.getWeight(weight) ?: Log.i("adsfadsf", "okay")
        }

        if (favorite){
            rootView.btn_favorite.text = "Unfavorite"
        }else{
            rootView.btn_favorite.text = "Favorite"
        }

        rootView.btn_favorite.setOnClickListener {
            if (!favorite){
                rootView.btn_favorite.text = "Unfavorite"
                favorite = true
                vehicles.forEach {
                    if (it.id == itemId){
                        it.favorite = favorite
                    }
                }
            }else{
                rootView.btn_favorite.text = "Favorite"
                favorite = false
                vehicles.forEach {
                    if (it.id == itemId){
                        it.favorite = favorite
                    }
                }
            }

        }

//        itemId = savedInstanceState?.getSerializable("Key") as Vehicle?
//        rootView.item_detail.text = itemId?.travel()
//
        return rootView
    }

    interface ObtainWeight{
        fun getWeight(weight: Int)
    }
    private var objectWeight: ObtainWeight? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is ObtainWeight){
            objectWeight = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        objectWeight = null
    }

    companion object {
        /**
         * The fragment argument representing the itemId ID that this fragment
         * represents.
         */
        const val ARG_ITEM_ID = "item_id"
    }
}
