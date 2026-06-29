package com.example.paymentsappone

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
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun Screen(
    pa: String,
    pn: String,
    amount: String,
    note: String,
    onSuccess: () -> Unit,
    onFailure: () -> Unit,
    onCancel: () -> Unit
) {

    Column(
        modifier = Modifier
            .safeDrawingPadding()
            .padding(20.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {

        Text(
            "Demo UPI App",
            style = MaterialTheme.typography.headlineSmall
        )

        Card {

            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                Text("Payee")
                Text(pn)

                HorizontalDivider()

                Text("UPI ID")
                Text(pa)

                HorizontalDivider()

                Text("Amount")
                Text("₹$amount")

                HorizontalDivider()

                Text("Note")
                Text(note)
            }
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onSuccess
        ) {
            Text("SUCCESS")
        }

        OutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = onFailure
        ) {
            Text("FAILURE")
        }

        TextButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = onCancel
        ) {
            Text("CANCEL")
        }
    }
}