package org.example.project.demo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.browser.window
import org.w3c.dom.PopStateEvent
import org.w3c.dom.events.Event

@Composable
fun Ap() {
    var currentScreen by remember { mutableStateOf(sortScreenFromPath(window.location.pathname)) }

    DisposableEffect(Unit) {
        val onPopState: (Event) -> Unit = { event ->
            val popStateEvent = event as? PopStateEvent
            if (popStateEvent != null) {
                currentScreen = sortScreenFromPath(window.location.pathname)
            }
        }

        window.addEventListener("popstate", onPopState)

        onDispose {
            window.removeEventListener("popstate", onPopState)
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Grid3DBackground()

        when (currentScreen) {
            SortScreen.BUBBLE -> {
                BubbleSortTitle3D()
                BubbleSortVisualizer(
                    onNavigateToInsertionSort = {
                        currentScreen = SortScreen.INSERTION
                        navigateTo(SortScreen.INSERTION)  // push state on navigation
                    }
                )
            }

            SortScreen.INSERTION -> {
                BubbleSortTitle3D(modifier = Modifier.padding(top = 30.dp))
                InsertionSortVisualizer(
                    onBack = {
                        currentScreen = SortScreen.BUBBLE
                        navigateTo(SortScreen.BUBBLE) // push state on back navigation
                    }
                )
            }
        }
    }
}
