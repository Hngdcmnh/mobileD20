package com.example.trainingmobiled20.fragment.gofoodFragment

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.trainingmobiled20.R
import com.example.trainingmobiled20.data.Oder

class GoFoodRecyclerViewAdapter(
    private val listOder: MutableList<Oder>,
    private val pressOderButtonListener: PressOderButtonListener
) :
    RecyclerView.Adapter<GoFoodRecyclerViewAdapter.ItemViewHolder>() {
    private lateinit var context: Context
//    private val VIEW_TYPE_ITEM = 0
//    private val VIEW_TYPE_LOADING = 1
//    private var isLoadingAdded: Boolean = false


//    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val tvBrand: AppCompatTextView = view.findViewById(R.id.tvBrand)
//        val tvRating: AppCompatTextView = view.findViewById(R.id.tvRating)
//        val tvOrderTime: AppCompatTextView = view.findViewById(R.id.tvOderTime)
//        val tvNote: AppCompatTextView = view.findViewById(R.id.tvNote)
//        val tvSumMoney: AppCompatTextView = view.findViewById(R.id.tvSumMoney)
//        val tvNumberDish: AppCompatTextView = view.findViewById(R.id.tvNumberDish)
//        val tvSavedMoney: AppCompatTextView = view.findViewById(R.id.tvSavedMoney)
//        val btnOder: AppCompatButton = view.findViewById(R.id.btnOderAgain)
//    }


//    override fun getItemViewType(position: Int): Int {
//        if (position == listOder.size - 1 && isLoadingAdded) {
//            return VIEW_TYPE_LOADING
//        }
//        return VIEW_TYPE_ITEM
//    }

    interface PressOderButtonListener {
        fun updateBill(priceOfDish: Double, numberDish: Int)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvBrand: AppCompatTextView = view.findViewById(R.id.tvBrand)
        val tvRating: AppCompatTextView = view.findViewById(R.id.tvRating)
        val tvOrderTime: AppCompatTextView = view.findViewById(R.id.tvOderTime)
        val tvNote: AppCompatTextView = view.findViewById(R.id.tvNote)
        val tvSumMoney: AppCompatTextView = view.findViewById(R.id.tvSumMoney)
        val tvNumberDish: AppCompatTextView = view.findViewById(R.id.tvNumberDish)
        val tvSavedMoney: AppCompatTextView = view.findViewById(R.id.tvSavedMoney)
        val btnOder: AppCompatButton = view.findViewById(R.id.btnOderAgain)
    }

//    class ProgressBarViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val progressBar: ProgressBar = view.findViewById(R.id.progressBar)
//    }


    override fun getItemCount(): Int = listOder.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        context = parent.context

//        return if (viewType == VIEW_TYPE_ITEM) {
//            val view = LayoutInflater.from(parent.context)
//                .inflate(R.layout.item_go_food, parent, false)
//
//            ItemViewHolder(view)
//        } else {
//            val view = LayoutInflater.from(parent.context)
//                .inflate(R.layout.item_loading, parent, false)
//
//            ProgressBarViewHolder(view)
//        }

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_go_food, parent, false)

        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
//        when (holder) {
//            is ItemViewHolder -> {
//                setContent(holder, position)
//                setOnclick(holder, position)
//            }
//            is ProgressBarViewHolder -> {
//
//            }
//        }
        setContent(holder, position)
        setOnclick(holder, position)
    }

    @SuppressLint("ResourceAsColor", "SetTextI18n")
    private fun setContent(holder: ItemViewHolder, position: Int) {
        val oder: Oder = listOder[position]

        val isCanOder: Boolean = oder.canOder
        holder.apply {
            btnOder.isEnabled = isCanOder

            if (!isCanOder) {
                btnOder.setTextColor(R.color.grey_200_dark)
            }
            with(oder) {
                tvBrand.text = brand
                tvRating.text = rating.toString()
                tvOrderTime.text = oderTime
                tvNote.text = note
                tvSumMoney.text = sumMoney.toString()
                tvNumberDish.text = "$numberDish món"
                tvSavedMoney.text = "Đã tiết kiệm ${savedMoney}k!"
            }
        }
    }

    private fun setOnclick(holder: ItemViewHolder, position: Int) {
        holder.btnOder.setOnClickListener {
            oder(holder, position)
        }
    }

    private fun oder(holder: ItemViewHolder, position: Int) {
        Toast.makeText(context, "Đặt lại đơn hàng ở ${holder.tvBrand.text}", Toast.LENGTH_LONG)
            .show()
        listOder[position].canOder = !listOder[position].canOder
        notifyItemChanged(position)

        pressOderButtonListener.updateBill(
            listOder[position].sumMoney,
            listOder[position].numberDish
        )
    }
}