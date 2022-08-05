package com.example.trainingmobiled20.fragment.gofoodFragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trainingmobiled20.data.Oder
import com.example.trainingmobiled20.databinding.FragmentGoFoodBinding

class GoFoodFragment : Fragment(), GoFoodRecyclerViewAdapter.PressOderButtonListener {
    private lateinit var binding: FragmentGoFoodBinding

    //for recyclerview
    private lateinit var goFoodRecyclerViewAdapter: GoFoodRecyclerViewAdapter
    private lateinit var layoutManager: LinearLayoutManager
    private val oderList = mutableListOf<Oder>()

    //for update oderlist:
    private var numberDish = 0
    private var sumMoneyOfAllDish = 0.0

    //for loadmore:
    private var currentPage = 1
    private var maxPage = 5
    private var limit = 5
    private var isLoading = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGoFoodBinding.inflate(inflater, container, false)

        setupRecyclerView()

        loadData()

        return binding.root
    }

    private fun setupRecyclerView() {
        val dividerItemDecoration = DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
        goFoodRecyclerViewAdapter = GoFoodRecyclerViewAdapter(oderList, this)

        binding.recyclerViewGoFood.adapter = goFoodRecyclerViewAdapter
        binding.recyclerViewGoFood.addItemDecoration(dividerItemDecoration)

        layoutManager = binding.recyclerViewGoFood.layoutManager as LinearLayoutManager

        binding.recyclerViewGoFood.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val visibleItemCount =
                    layoutManager.childCount //số item đang hiển thị trên màn hình
                val firstVisibleItemPosition =
                    layoutManager.findFirstVisibleItemPosition() //vị trí của item đầu tiên đang hiển thị trên màn hình
                val totalItemCount =
                    goFoodRecyclerViewAdapter.itemCount //tổng số item đang có trong Layout (số dữ liệu đã load)

                //Kỹ thuật phân trang:
                if (!isLoading && currentPage <= maxPage) {
                    //số item đang hiển thị trên màn hình + vị trí của item đầu tiên hiển thị trên màn hình = tổng số item có trong layout <=> đã kéo xuống cuối trang
                    if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount) {
                        currentPage++
                        loadData()
                    }
                }

                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }

    @SuppressLint("NotifyDataSetChanged")
    fun loadData() {
        isLoading = true
        binding.progressBar.visibility = View.VISIBLE

        Handler(Looper.getMainLooper()).postDelayed({
            if (::goFoodRecyclerViewAdapter.isInitialized) {
                getOder()
                goFoodRecyclerViewAdapter.notifyDataSetChanged()
            }

            isLoading = false
            binding.progressBar.visibility = View.GONE
        }, 3000)
    }

    private fun getOder() {
        repeat(limit) {
            oderList.add(Oder())
        }
    }

    @SuppressLint("SetTextI18n")
    override fun updateBill(priceOfDish: Double, numberDish: Int) {
        this.sumMoneyOfAllDish += priceOfDish
        binding.tvSumMoneyOfAllDish.text = this.sumMoneyOfAllDish.toString()

        this.numberDish += numberDish
        binding.tvSumDish.text = this.numberDish.toString() + " món"
    }
}