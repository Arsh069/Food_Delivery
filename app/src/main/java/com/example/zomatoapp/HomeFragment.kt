package com.example.zomatoapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zomatoapp.Adapter.FoodAdapter
import com.example.zomatoapp.Repository.Repository
import com.example.zomatoapp.ViewModel.MainViewModel
import com.example.zomatoapp.ViewModel.MainViewModelFactory
import com.example.zomatoapp.api.CollectionX
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    private val foodAdapter:FoodAdapter by lazy{FoodAdapter(requireContext())}
    private lateinit var viewModel: MainViewModel
    private lateinit var repository: Repository

    private var res= emptyList<CollectionX>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View =  inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.rv_recyclerView)

        val repository=Repository(this.requireContext())
        val vmf= MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,vmf).get(MainViewModel::class.java)

        viewModel.getFood(26.8467, 80.9462)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = foodAdapter

        viewModel.showProgress.observe(viewLifecycleOwner, Observer {
            if (it)
                progressbar.visibility = View.VISIBLE
            else
                progressbar.visibility = View.GONE
        })


        viewModel.food.observe(viewLifecycleOwner, Observer {
            Log.d("BOLT","success"+it.toString())



                it.body()?.let {pt->

                    foodAdapter.setStateWiseTracker(res)
                    progressbar.visibility= View.GONE
                }



        })
    }

}
