@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.questnavigasiui_214.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.questnavigasiui_214.R

@Composable
fun FormIsian(
    jenisK: List<String> = listOf("Laki-laki", "Perempuan"),
    onSubmitClick: (String, String, String) -> Unit
) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.home),
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700)
                )
            )
        }
    ) { isiRuang ->

        var nama by remember { mutableStateOf("") }
        var alamat by remember { mutableStateOf("") }
        var jenisKelamin by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .padding(paddingValues = isiRuang)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // ---- Input Nama Lengkap ----
            OutlinedTextField(
                value = nama,
                onValueChange = { nama = it },
                label = { Text(text = "Nama Lengkap") },
                singleLine = true,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .width(250.dp)
            )

            // ---- Divider merah ----
            HorizontalDivider(
                modifier = Modifier
                    .padding(all = 20.dp)
                    .width(250.dp),
                thickness = 1.dp,
                color = Color.Red
            )

            // ---- Pilihan Jenis Kelamin ----
            Row {
                jenisK.forEach { item ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    ) {
                        RadioButton(
                            selected = (jenisKelamin == item),
                            onClick = { jenisKelamin = item }
                        )
                        Text(text = item)
                    }
                }
            }

            // ---- Divider merah lagi ----
            HorizontalDivider(
                modifier = Modifier
                    .padding(all = 20.dp)
                    .width(250.dp),
                thickness = 1.dp,
                color = Color.Red
            )

            // ---- Input Alamat ----
            OutlinedTextField(
                value = alamat,
                onValueChange = { alamat = it },
                label = { Text(text = "Alamat") },
                singleLine = true,
                modifier = Modifier.width(250.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))

            // ---- Tombol Submit ----
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { onSubmitClick(nama, jenisKelamin, alamat) }
            ) {
                Text(text = stringResource(id = R.string.submit))
            }
        }
    }
}
