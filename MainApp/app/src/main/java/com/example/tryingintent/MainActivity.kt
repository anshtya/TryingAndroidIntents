package com.example.tryingintent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.tryingintent.ui.theme.TryingIntentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TryingIntentTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    var intentResponse by remember { mutableStateOf("") }

                    val launcher = rememberLauncherForActivityResult(
                        contract = ActivityResultContracts.StartActivityForResult()
                    ) { result ->
                        intentResponse = if (result.resultCode == RESULT_OK) {
                            result.data?.getStringExtra("response")?: "No response"
                        } else {
                            "Payment Cancelled"
                        }
                    }

                    Screen(
                        onPayClick = { pa, pn, amount, note ->
                            val uri = Uri.Builder()
                                .scheme("upi")
                                .authority("pay")
                                .appendQueryParameter("pa", pa)
                                .appendQueryParameter("pn", pn)
                                .appendQueryParameter("tn", note)
                                .appendQueryParameter("am", amount)
                                .appendQueryParameter("cu", "INR")
                                .build()

                            val intent = Intent(Intent.ACTION_VIEW).apply {
                                data = uri
                            }
                            launcher.launch(intent)
                        },
                        response = intentResponse
                    )
                }
            }
        }
    }
}