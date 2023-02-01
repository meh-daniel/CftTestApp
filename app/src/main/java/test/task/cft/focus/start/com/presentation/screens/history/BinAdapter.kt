package test.task.cft.focus.start.com.presentation.screens.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import test.task.cft.focus.start.com.R
import test.task.cft.focus.start.com.databinding.ItemBinBinding
import test.task.cft.focus.start.com.domain.model.Bin

class BinAdapter : ListAdapter<Bin, RecyclerView.ViewHolder>(RepositoryDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when(viewType){
        R.layout.item_bin -> BinViewHolder.from(parent)
        else ->  throw Throwable("onCreateViewHolder exception - unknown view type by name: $viewType")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = when(holder) {
        is BinViewHolder -> holder.bind(item = getItem(position))
        else -> throw Throwable("onBindViewHolder exception - unknown holder of view by name ${holder.itemView.id}")
    }

    override fun getItemViewType(position: Int): Int = when(getItem(position)){
        is Bin -> R.layout.item_bin
        else -> throw Exception("getItemViewType unknown item class exception from position: $position")
    }
}

class BinViewHolder(private val binding: ItemBinBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(item: Bin){
        with(binding) {

            numberCard.text = item.number.numberCard
            numberCardLength.text = item.number.length.toString()
            numberCardLuhn.text = if(item.number.luhn) "yes" else "no"


            // General
            generalScheme.text = item.scheme
            generalType.text = item.type
            generalBrand.text = item.brand
            generalPrepaid.text = if(item.prepaid) "yes" else "no"

            // Country
            countryNumeric.text = item.country.numeric
            countryAlpha2.text = item.country.alpha2
//            countryName.setTextColor(context.resources.getColor(R.color.urlColor, null))
//            countryName.toGeoLink(context, item.country.name)
            countryName.text = item.country.name
            countryEmoji.text = item.country.emoji
            countryCurrency.text = item.country.currency
            countryLatitude.text = item.country.latitude.toString()
            countryLongitude.text = item.country.longitude.toString()

            // Bank
            bankName.text = item.bank.name
            bankUrl.text = item.bank.url
            bankPhone.text = item.bank.phone

//            bankCity.setTextColor(context.resources.getColor(R.color.urlColor, null))
//            bankCity.toGeoLink(context, item.bank.city)
            bankCity.text = item.bank.city

        }
    }

    companion object {
        fun from(parent: ViewGroup): RecyclerView.ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemBinBinding.inflate(layoutInflater, parent, false)
            return BinViewHolder(binding)
        }
    }
}

class RepositoryDiffUtil: DiffUtil.ItemCallback<Bin>() {
    override fun areItemsTheSame(
        oldItem: Bin,
        newItem: Bin
    ): Boolean = oldItem == newItem

    override fun areContentsTheSame(
        oldItem: Bin,
        newItem: Bin
    ): Boolean = oldItem == newItem
}
