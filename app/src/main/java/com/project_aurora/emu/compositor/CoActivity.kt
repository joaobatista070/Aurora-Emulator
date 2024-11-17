package com.project_aurora.emu.compositor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.project_aurora.emu.databinding.ActivityCompositorWrapperBinding

class CoActivity : AppCompatActivity() {
    private var _binding: ActivityCompositorWrapperBinding? = null
    private val binding: ActivityCompositorWrapperBinding get() = _binding!!
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityCompositorWrapperBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
