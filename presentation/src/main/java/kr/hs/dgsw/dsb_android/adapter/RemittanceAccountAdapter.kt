package kr.hs.dgsw.dsb_android.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.hs.dgsw.domain.entity.Account
import kr.hs.dgsw.dsb_android.R
import kr.hs.dgsw.dsb_android.adapter.RemittanceAccountAdapter.RemittanceAccountViewHolder
import kr.hs.dgsw.dsb_android.adapter.callback.AccountDiffUtilCallBack
import kr.hs.dgsw.dsb_android.databinding.ItemRemittanceAccountBinding
import kr.hs.dgsw.dsb_android.util.SingleLiveEvent
import kr.hs.dgsw.dsb_android.viewmodel.item.RemittanceAccountItemViewModel

class RemittanceAccountAdapter(val lifecycleOwner: LifecycleOwner) :
    ListAdapter<Account, RemittanceAccountViewHolder>(AccountDiffUtilCallBack) {

    class RemittanceAccountViewHolder(private val binding: ItemRemittanceAccountBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Account, lifecycleOwner: LifecycleOwner) {
            val viewModel = RemittanceAccountItemViewModel()

            viewModel.bind(data)
            binding.vm = viewModel

            Glide.with(binding.root)
                .load(data.accountProfileImage)
                .error(R.mipmap.ic_launcher)
                .into(binding.ivProfileImage)

            viewModel.onClickAccountEvent.observe(lifecycleOwner, {
                onClickAccount.value = data.idx
            })

        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RemittanceAccountViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemRemittanceAccountBinding>(
            layoutInflater,
            R.layout.item_remittance_account,
            parent,
            false
        )

        return RemittanceAccountViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: RemittanceAccountViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position), lifecycleOwner)
    }

    companion object {
        val onClickAccount = SingleLiveEvent<Int>()
    }
}