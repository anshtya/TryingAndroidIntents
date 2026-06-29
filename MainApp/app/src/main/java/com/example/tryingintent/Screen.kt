package com.example.tryingintent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Screen(
    onPayClick: (
        pa: String,
        pn: String,
        amount: String,
        note: String
    ) -> Unit,
    response: String,
) {

    var pa by remember { mutableStateOf("merchant@demo") }
    var pn by remember { mutableStateOf("Demo Merchant") }
    var amount by remember { mutableStateOf("10.00") }
    var note by remember { mutableStateOf("Test Payment") }

    Column(
        modifier = Modifier
            .safeDrawingPadding()
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            "UPI Consumer Demo With Android Intents",
            style = MaterialTheme.typography.headlineSmall
        )

        OutlinedTextField(
            value = pa,
            onValueChange = { pa = it },
            label = { Text("Payee VPA") }
        )

        OutlinedTextField(
            value = pn,
            onValueChange = { pn = it },
            label = { Text("Payee Name") }
        )

        OutlinedTextField(
            value = amount,
            onValueChange = { amount = it },
            label = { Text("Amount") }
        )

        OutlinedTextField(
            value = note,
            onValueChange = { note = it },
            label = { Text("Transaction Note") }
        )

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onPayClick(pa, pn, amount, note)
            }
        ) {
            Text("Launch UPI Payment")
        }

        HorizontalDivider()

        Text("Last Response")

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                response,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}