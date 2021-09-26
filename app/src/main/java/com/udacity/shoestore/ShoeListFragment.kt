package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false
        )
        binding.viewModel = viewModel
        addShoes()
        binding.addButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeListFragment_to_shoeDetailFragment)
        )

        viewModel.shoes.observe(viewLifecycleOwner, Observer {
            //viewModel.shoe.value?.let { it1 -> addShoe(it1) }
            val linLayout = binding.lines
            linLayout.removeAllViews()
            addShoes()
        })

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.navdrawer_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun addShoes(){
        for(s in viewModel.shoes.value!!){
            addShoe(s)
        }
    }

    private fun addShoe(shoe: Shoe){
        val linLayout = binding.lines
        val shoeView = TextView(context)
        shoeView.text = shoe.name + " by " + shoe.company + ", size " + shoe.size.toString() + ": " + shoe.description
        shoeView.textSize = 20.0F
        shoeView.setTextAppearance(R.style.ListItemTheme)
        Timber.i("Here is the dimen value: " + resources.getDimension(R.dimen.text_size))
        //val shoeDesc = TextView(context)
        //shoeDesc.text = shoe.description
        linLayout.addView(shoeView)
    }


}