package com.example.questnavigasiui_214

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.questnavigasiui_214.view.FormIsian
import com.example.questnavigasiui_214.view.TampilData

enum class Navigasi {
    Formulir,
    Detail
}

@Composable
fun DataApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    Scaffold { isiRuang ->
        NavHost(
            navController = navController,
            startDestination = "Formulir",
            modifier = modifier.padding(paddingValues = isiRuang)
        ) {
            // 📋 Screen Formulir
            composable(route = "Formulir") {
                FormIsian(
                    onSubmitClick = { nama, jenisKelamin, alamat ->
                        // navigasi ke halaman detail sambil kirim data
                        navController.navigate("Detail/$nama/$jenisKelamin/$alamat")
                    }
                )
            }

            // 📋 Screen Detail (TampilData)
            composable(
                route = "Detail/{nama}/{jenisKelamin}/{alamat}"
            ) { backStackEntry ->
                val nama = backStackEntry.arguments?.getString("nama") ?: ""
                val jenisKelamin = backStackEntry.arguments?.getString("jenisKelamin") ?: ""
                val alamat = backStackEntry.arguments?.getString("alamat") ?: ""

                TampilData(
                    nama = nama,
                    jenisKelamin = jenisKelamin,
                    alamat = alamat,
                    onBackBtnClick = {
                        cancelAndBackToFormulir(navController)
                    }
                )
            }
        }
    }
}

private fun cancelAndBackToFormulir(navController: NavHostController) {
    navController.popBackStack(
        route = "Formulir",
        inclusive = false
    )
}
