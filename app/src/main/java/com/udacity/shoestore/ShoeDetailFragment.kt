package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import timber.log.Timber
import java.lang.NumberFormatException


class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding
    private val viewModel: ShoeListViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_shoe_detail,container,false
        )
        binding.saveButton.setOnClickListener{
            //Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoeListFragment)
            saveNavigateSafe(it)
        }
        binding.cancelButton.setOnClickListener {
            //Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoeListFragment)
            cancelNavigate(it)
        }
        binding.viewModel = viewModel
        Timber.plant(Timber.DebugTree())
        return binding.root
    }


    private fun saveNavigateSafe(view: View){
        try {
            if(binding.shoeNameEdit.text.isNullOrBlank() || binding.shoeCompanyEdit.text.isNullOrBlank() || binding.shoeDescEdit.text.isNullOrBlank()){
                 throw Exception("Blank info!")
            }
            viewModel.addShoe()
            Navigation.findNavController(view).navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }
        catch(e : Exception){
            Toast.makeText(context,"Oops! Check your entry or Cancel!",Toast.LENGTH_LONG).show()
        }
    }

    private fun cancelNavigate(view: View){
        viewModel.shoe.value = Shoe()
        Navigation.findNavController(view).navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
    }

//    private fun addShoe(view: View){
//
//        binding.apply{
//
//            try {
//                if(shoeNameEdit.text.isNullOrBlank() || shoeCompanyEdit.text.isNullOrBlank() || shoeDescEdit.text.isNullOrBlank()){
//                    throw Exception("Blank info!")
//                }
//                shoe = Shoe(
//                    shoeNameEdit.text.toString(),
//                    shoeSizeEdit.text.toString().toDouble(),
//                    shoeCompanyEdit.text.toString(),
//                    shoeDescEdit.text.toString()
//                )
//                Timber.i(shoe.toString())
//                Timber.i(shoe?.name)
//                invalidateAll()
//                viewModel.shoe.value = shoe
//                viewModel.addShoe()
//                Navigation.findNavController(view).navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
//
//            } catch (e: Exception){
//               Toast.makeText(context,"Oops! Check your entry or Cancel!",Toast.LENGTH_LONG).show()
//            }
//        }
//        /*addShoeName(view)
//        addShoeCompany(view)
//        addShoeSize(view)
//        addShoeDesc(view)*/
//    }

    /*
    private fun addShoeName(view: View){
        binding.apply {
            //shoeNameView.text = shoeNameEdit.text
            shoe?.name = shoeNameEdit.text.toString()
            invalidateAll()
        }
    }

    private fun addShoeCompany(view: View){
        binding.apply{
            //shoeCompanyView.text = shoeNameEdit.text
            shoe?.company = shoeNameEdit.text.toString()
            invalidateAll()
        }
    }

    private fun addShoeSize(view: View){
        binding.apply{
            //shoeSizeView.text = shoeSizeEdit.text
            shoe?.size = shoeSizeEdit.text.toString().toDouble()
            invalidateAll()
        }
    }

    private fun addShoeDesc(view: View){
        binding.apply {
            //shoeDescView.text = shoeDescEdit.text
            shoe?.description = shoeDescEdit.text.toString()
            invalidateAll()
        }
    } */


}