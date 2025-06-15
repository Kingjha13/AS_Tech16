//package org.example.project.demo
//
//import kotlinx.browser.window
//
//enum class SortScreen(val path: String) {
//    BUBBLE("/bubble-sort"),
//    INSERTION("/insertion-sort");
//
//    companion object {
//        fun fromPath(path: String): SortScreen = when (path) {
//            "/", "/bubble-sort" -> BUBBLE
//            "/insertion-sort" -> INSERTION
//            else -> BUBBLE
//        }
//    }
//}
//
//fun navigateTo(screen: SortScreen) {
//    if (window.location.pathname != screen.path) {
//        window.history.pushState(null, "", screen.path)
//    }
//}


package org.example.project.demo

import kotlinx.browser.window
import org.w3c.dom.PopStateEvent

val SortScreen.path: String
    get() = when (this) {
        SortScreen.BUBBLE -> "/bubble-sort"
        SortScreen.INSERTION -> "/insertion-sort"
    }

fun sortScreenFromPath(path: String): SortScreen = when (path) {
    "/", "/bubble-sort" -> SortScreen.BUBBLE
    "/insertion-sort" -> SortScreen.INSERTION
    else -> SortScreen.BUBBLE
}

fun navigateTo(screen: SortScreen) {
    if (window.location.pathname != screen.path) {
        window.history.pushState(null, "", screen.path)
    }
}
