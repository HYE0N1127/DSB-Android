package kr.hs.dgsw.dsb_android.adapter.callback

import androidx.recyclerview.widget.DiffUtil
import kr.hs.dgsw.domain.entity.Account

object AccountDiffUtilCallBack : DiffUtil.ItemCallback<Account>() {
    override fun areItemsTheSame(oldItem: Account, newItem: Account): Boolean {
        return oldItem.idx == newItem.idx
    }

    override fun areContentsTheSame(oldItem: Account, newItem: Account): Boolean {
        return oldItem.idx == newItem.idx
    }

}