package com.apkforge.quanlychitieu2appqua

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.apkforge.quanlychitieu2appqua.ui.theme.QuanLyChiTieu2AppQuanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuanLyChiTieu2AppQuanTheme {
                QuanLyChiTieu2AppQuanApp()
            }
        }
    }
}
