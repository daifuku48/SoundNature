package com.danylkharytonovuaa.soundnature

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.danylkharytonovuaa.soundnature.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    var binding: MainActivityBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val array = ArrayList<Nature>().apply {
            add(Nature("Lava", Data.lava_audio, Data.lava, Data.lava_intent))
            add(Nature("Storm", Data.storm_audio, Data.storm, Data.storm_intent))
            add(Nature("Waterfall", Data.waterfall_audio, Data.waterfall, Data.waterfall_intent))
            add(Nature("Wind", Data.wind_audio, Data.wind, Data.wind_intent))
            add(Nature("Waves", Data.waves_audio, Data.waves, Data.waves_intent))
        }
        binding?.listItem?.layoutManager = LinearLayoutManager(this)
        val adapter = RecAdapter(array)
        adapter.setOnItemClickListener(object: RecAdapter.OnItemClickListener{
            override fun onClickItem(position: Int) {
                val intent = Intent(this@MainActivity, SecondActivity::class.java).apply {
                    putExtra("audio", array[position].audio)
                    putExtra("image", array[position].image_intent)
                }
                startActivity(intent)
            }

        })
        binding?.listItem?.adapter = adapter

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}