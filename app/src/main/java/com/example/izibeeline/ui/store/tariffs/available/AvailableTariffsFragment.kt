package com.example.izibeeline.ui.store.tariffs.available

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.izibeeline.R
import com.example.izibeeline.databinding.FragmentAvailableTariffsBinding
import com.example.izibeeline.ui.store.tariffs.TariffInfoActivity
import com.example.izibeeline.ui.store.tariffs.TestModel
import com.example.izibeeline.ui.store.tariffs.adapter.AvailableTariffsAdapter


class AvailableTariffsFragment : Fragment(R.layout.fragment_available_tariffs) {

    private val binding by viewBinding<FragmentAvailableTariffsBinding>()
    private val adapter = AvailableTariffsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    private fun initUI() = with(binding) {
        val b = TestModel(1,R.drawable.available_1,"Пропущенные звонки","Остался высоко в горах без связи? IZI оповестит о любом пропущенном звонке. Услуга уже у тебя в смартфоне.")
        val c = TestModel(2,R.drawable.available_2,"eSIM","Заведи, восстанови или настрой eSIM")
        val d = TestModel(3,R.drawable.available_3,"Бесплатные 30 ГБ на 7 дней","Оцени интернет от IZI с самым большим пакетом гигабайтов")
        val i = TestModel(4,R.drawable.available_4,"Pump","Делись гигабайтами, минутами и SMS")

        availableTariffsRV.adapter = adapter
        adapter.submitList(listOf(b, c, d, i))

        adapter.setOnItemClick {
            startActivity(Intent(requireActivity(), TariffInfoActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        requireView().requestLayout()
    }
}