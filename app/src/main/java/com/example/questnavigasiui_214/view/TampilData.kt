package com.example.questnavigasiui_214.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.res.stringResource
import androidx.compose.material3.R
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.res.dimensionResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilData(
    onBackBtnClick: () -> Unit
) {
    val items = listOf(
        Pair(first = stringResource(id = R.string.nama_lengkap), second = "Contoh Nama"),
        Pair(first = stringResource(id = R.string.jenis_kelamin), second = "Lainnya"),
        Pair(first = stringResource(id = R.string.alamat), second = "Yogyakarta")
    )
    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.tampil),
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700)
                )
            )
        }
    ) { isiRuang ->
        Column(
            modifier = Modifier.padding(paddingValues = isiRuang),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.padding(all = dimensionResource(id = R.dimen.padding_medium)),
                verticalArrangement = Arrangement.spacedBy(
                    space = dimensionResource(id = R.dimen.padding_small)
                )
            ) {

            }
        }

    }

}
