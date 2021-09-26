package com.udacity.shoestore

import androidx.databinding.Bindable
import androidx.databinding.InverseMethod
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel: ViewModel() {
    /* add to Shoe List fragment
    viewModel.shoes.observe(this, Observer { t -> })
     */
    private val _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes

    //private val _shoe = MutableLiveData<Shoe>()
    val shoe = MutableLiveData<Shoe>()



    fun addShoe(){
        if(shoe.value != null){
            _shoes.value?.add(shoe.value!!)
        }
        shoe.value = Shoe()
    }


    init {
        val shoe1 = Shoe(name="Air Jordan",size=10.5, company="Nike",description = "Gotta get your ups!")
        val shoe2 = Shoe(name="Superstar",size=12.0,company="addidas",description="rocking it on the boardwalk")
        val shoe3 = Shoe(name="King Toe",size=11.5, company="Red Wing",description = "When you got to get the work done")
        _shoes.value = mutableListOf(shoe1,shoe2,shoe3)
        shoe.value = Shoe()
    }

//    object Converter {
//
//        @InverseMethod("toDouble")
//        @JvmStatic
//        fun toString(
//            value: Double
//        ): String {
//            return value.toString()
//        }
//
//        @JvmStatic
//        fun toDouble(
//            value: String
//        ): Double {
//            return (value?.toDouble() ?: 0.0)
//        }
//    }

}