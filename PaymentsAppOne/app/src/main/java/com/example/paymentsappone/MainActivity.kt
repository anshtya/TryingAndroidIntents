package com.example.paymentsappone

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.paymentsappone.ui.theme.PaymentsAppOneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val uri = intent.data
        val pa = uri?.getQueryParameter("pa") ?: ""
        val pn = uri?.getQueryParameter("pn") ?: ""
        val amount = uri?.getQueryParameter("am") ?: ""
        val note = uri?.getQueryParameter("tn") ?: ""

        setContent {
            PaymentsAppOneTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Screen(pa = pa,
                        pn = pn,
                        amount = amount,
                        note = note,
                        onSuccess = {
                            val result = Intent().apply {
                                putExtra(
                                    "response", "Status=SUCCESS&txnId=TXN123456&txnRef=REF123"
                                )
                            }
                            setResult(RESULT_OK, result)
                            finish()
                        },
                        onFailure = {
                            val result = Intent().apply {
                                putExtra("response", "Status=FAILURE")
                            }
                            setResult(RESULT_OK, result)
                            finish()
                        },
                        onCancel = {
                            setResult(RESULT_CANCELED)
                            finish()
                        }
                    )
                }
            }
        }
    }
}