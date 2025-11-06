package com.example.questnavigasiui_214

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
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
    navController: NavController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    Scaffold { isiRuang ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulir.name,
            modifier = Modifier.padding(paddingValues = isiRuang)
        ) {
            composable(route = Navigasi.Formulir.name) {
                FormIsian(
                    onSubmitClick = {
                        navController.navigate(route = Navigasi.Detail.name)
                    }
                )
            }

            composable(route = Navigasi.Detail.name) {
                TampilData(
                    onBackBtnClick = {
                        cancelAndBackToFormulir(navController)
                    }
                )
            }
        }
    }
}

private fun cancelAndBackToFormulir(
    navController: NavController
) {
    navController.popBackStack(
        route = Navigasi.Formulir.name,
        inclusive = false
    )
}
