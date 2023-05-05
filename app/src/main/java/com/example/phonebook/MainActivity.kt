package com.example.phonebook

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mynotes.screens.TrashScreen
import com.example.phonebook.ui.theme.PhoneBookTheme
import com.example.phonebook.routing.PhoneBookRouter
import com.example.phonebook.routing.Screen
import com.example.phonebook.screens.PhoneBookScreen
import com.example.phonebook.screens.SavePhoneScreen
import com.example.phonebook.ui.theme.PhoneBookThemeSettings
import com.example.phonebook.viewmodel.MainViewModel
import com.example.phonebook.viewmodel.MainViewModelFactory

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhoneBookTheme(darkTheme = PhoneBookThemeSettings.isDarkThemeEnabled) {
                val viewModel: MainViewModel = viewModel(
                    factory = MainViewModelFactory(LocalContext.current.applicationContext as Application)
                )
                MainActivityScreen(viewModel)
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun MainActivityScreen(viewModel: MainViewModel) {
    Surface {
        when (PhoneBookRouter.currentScreen) {
            is Screen.Phones -> PhoneBookScreen(viewModel)
            is Screen.SavePhone -> SavePhoneScreen(viewModel)
            is Screen.Trash -> TrashScreen(viewModel)
        }
    }
}