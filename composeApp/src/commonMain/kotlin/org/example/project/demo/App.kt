package org.example.project.demo

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import org.jetbrains.compose.resources.painterResource
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource

import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.compose_multiplatform
import kotlinx.coroutines.delay
//@Composable
//@Preview
//fun App() {
//    MaterialTheme {
//        var showContent by remember { mutableStateOf(false) }
//        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//            Button(onClick = { showContent = !showContent }) {
//                Text("Hello Avanish jha you can do anything.!")
//            }
//            AnimatedVisibility(showContent) {
//                val greeting = remember { Greeting().greet() }
//                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//                    Image(painterResource(Res.drawable.compose_multiplatform), null)
//                    Text("Compose: $greeting")
//                }
//            }
//        }
//    }
//}

//@Composable
//fun BubbleSortVisualizer() {
//    var userInput by remember { mutableStateOf("5,3,8,1,2") }
//    var values by remember { mutableStateOf(parseInput(userInput)) }
//    var animatedValues = remember { mutableStateListOf<Int>().apply { addAll(values) } }
//    var isSorting by remember { mutableStateOf(false) }
//    var isPaused by remember { mutableStateOf(true) }
//    var comparisonMessage by remember { mutableStateOf("") }
//    var showInputField by remember { mutableStateOf(false) }
//    var sortTrigger by remember { mutableStateOf(0) }
//    var comparingIndices by remember { mutableStateOf<Pair<Int, Int>?>(null) }
//
//    val delayTime = 800L // Fixed default delay
//
//    LaunchedEffect(sortTrigger) {
//        isSorting = true
//        for (i in 0 until animatedValues.size - 1) {
//            for (j in 0 until animatedValues.size - i - 1) {
//                while (isPaused) delay(100L)
//
//                comparingIndices = j to j + 1
//                val a = animatedValues[j]
//                val b = animatedValues[j + 1]
//
//                comparisonMessage = when {
//                    a > b -> {
//                        animatedValues[j] = b
//                        animatedValues[j + 1] = a
//                        "Comparing $a > $b — Swapped"
//                    }
//                    a < b -> "Comparing $a < $b — No swap needed"
//                    else -> "Comparing $a == $b — No swap needed"
//                }
//
//                delay(delayTime)
//            }
//        }
//        isSorting = false
//        isPaused = true
//        comparisonMessage = "✅ Sorting complete!"
//        comparingIndices = null
//    }
//
//    LaunchedEffect(comparisonMessage) {
//        if (comparisonMessage == "✅ Sorting complete!") {
//            delay(2000L)
//            comparisonMessage = ""
//        }
//    }
//
//    val maxBarValue = animatedValues.maxOrNull()?.takeIf { it > 0 } ?: 1
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(top = 40.dp)
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        if (comparisonMessage.isNotEmpty()) {
//            Text(
//                text = comparisonMessage,
//                fontWeight = FontWeight.Medium,
//                fontSize = 18.sp,
//                color = Color.Magenta
//            )
//        }
//
//        Spacer(modifier = Modifier.height(10.dp))
//
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceEvenly
//        ) {
//            animatedValues.forEachIndexed { index, value ->
//                val heightFactor = value.toFloat() / maxBarValue
//                val barHeight = (heightFactor * 200).dp.coerceAtLeast(40.dp)
//                val isCompared = comparingIndices?.first == index || comparingIndices?.second == index
//
//                Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                    Text(text = value.toString())
//                    Spacer(modifier = Modifier.height(4.dp))
//                    Box(
//                        modifier = Modifier
//                            .width(40.dp)
//                            .height(barHeight)
//                            .background(
//                                if (isCompared) Color.Red else Color(0xFF2196F3),
//                                shape = RoundedCornerShape(6.dp)
//                            )
//                    )
//                }
//            }
//        }
//
//        Spacer(modifier = Modifier.height(12.dp))
//
//        if (showInputField) {
//            OutlinedTextField(
//                value = userInput,
//                onValueChange = {
//                    userInput = it
//                    values = parseInput(userInput)
//                    animatedValues.clear()
//                    animatedValues.addAll(values)
//                    comparisonMessage = ""
//                },
//                label = { Text("Enter numbers (e.g. 5,3,8,1,2)") },
//                singleLine = true,
//                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
//                modifier = Modifier.fillMaxWidth()
//            )
//            Spacer(modifier = Modifier.height(13.dp))
//        }
//
//        Row {
//            Button(onClick = {
//                showInputField = !showInputField
//            }) {
//                Text(if (showInputField) "Hide Input ❌" else "Edit Input ✏️")
//            }
//
//            Spacer(modifier = Modifier.width(16.dp))
//
//            IconButton(onClick = {
//                if (!isSorting) {
//                    values = parseInput(userInput)
//                    animatedValues.clear()
//                    animatedValues.addAll(values)
//                    isPaused = false
//                    sortTrigger++
//                } else {
//                    isPaused = !isPaused
//                }
//            }) {
//                Icon(
//                    imageVector = if (!isSorting || isPaused)
//                        Icons.Filled.PlayArrow
//                    else
//                        Icons.Filled.Build,
//                    contentDescription = if (!isSorting || isPaused) "Start or Continue" else "Pause",
//                    modifier = Modifier.size(36.dp),
//                    tint = Color.Unspecified
//                )
//
//            }
//
//            Spacer(modifier = Modifier.width(16.dp))
//
//            Button(
//                onClick = {
//                    if (!isSorting) {
//                        values = parseInput(userInput)
//                        animatedValues.clear()
//                        animatedValues.addAll(values)
//                        isPaused = false
//                        sortTrigger++
//                    }
//                },
//                enabled = !isSorting
//            ) {
//                Text("Visualize Sort 🚀")
//            }
//        }
//    }
//}
//fun parseInput(input: String): List<Int> {
//    return input.split(",").mapNotNull {
//        it.trim().toIntOrNull()
//    }
//}

@Composable
fun BubbleSortVisualizer() {
    var userInput by remember { mutableStateOf("5,3,8,1,2") }
    var values by remember { mutableStateOf(parseInput(userInput)) }
    var animatedValues = remember { mutableStateListOf<Int>().apply { addAll(values) } }
    var isSorting by remember { mutableStateOf(false) }
    var isPaused by remember { mutableStateOf(true) }
    var comparisonMessage by remember { mutableStateOf("") }
    var showInputField by remember { mutableStateOf(false) }
    var sortTrigger by remember { mutableStateOf(0) }
    var comparingIndices by remember { mutableStateOf<Pair<Int, Int>?>(null) }

    val delayTime = 800L

    LaunchedEffect(sortTrigger) {
        isSorting = true
        for (i in 0 until animatedValues.size - 1) {
            for (j in 0 until animatedValues.size - i - 1) {
                while (isPaused) delay(100L)

                comparingIndices = j to j + 1
                val a = animatedValues[j]
                val b = animatedValues[j + 1]

                comparisonMessage = when {
                    a > b -> {
                        animatedValues[j] = b
                        animatedValues[j + 1] = a
                        "Comparing $a > $b — Swapped"
                    }
                    a < b -> "Comparing $a < $b — No swap needed"
                    else -> "Comparing $a == $b — No swap needed"
                }

                delay(delayTime)
            }
        }
        isSorting = false
        isPaused = true
        comparisonMessage = "✅ Sorting complete!"
        comparingIndices = null
    }

    LaunchedEffect(comparisonMessage) {
        if (comparisonMessage == "✅ Sorting complete!") {
            delay(2000L)
            comparisonMessage = ""
        }
    }

    val maxBarValue = animatedValues.maxOrNull()?.takeIf { it > 0 } ?: 1

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (comparisonMessage.isNotEmpty()) {
            Text(
                text = comparisonMessage,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                color = Color.Magenta
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            animatedValues.forEachIndexed { index, value ->
                val heightFactor = value.toFloat() / maxBarValue
                val barHeight = (heightFactor * 200).dp.coerceAtLeast(40.dp)
                val isCompared = comparingIndices?.first == index || comparingIndices?.second == index

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = value.toString())
                    Spacer(modifier = Modifier.height(4.dp))
                    Box(
                        modifier = Modifier
                            .width(40.dp)
                            .height(barHeight)
                            .background(
                                if (isCompared) Color.Red else Color(0xFF2196F3),
                                shape = RoundedCornerShape(6.dp)
                            )
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        if (showInputField) {
            OutlinedTextField(
                value = userInput,
                onValueChange = {
                    userInput = it
                    values = parseInput(userInput)
                    animatedValues.clear()
                    animatedValues.addAll(values)
                    comparisonMessage = ""
                },
                label = { Text("Enter numbers (e.g. 5,3,8,1,2)") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(13.dp))
        }

        Row {
            Button(onClick = {
                showInputField = !showInputField
            }) {
                Text(if (showInputField) "Hide Input ❌" else "Edit Input ✏️")
            }

            Spacer(modifier = Modifier.width(16.dp))

            IconButton(onClick = {
                if (!isSorting) {
                    values = parseInput(userInput)
                    animatedValues.clear()
                    animatedValues.addAll(values)
                    isPaused = false
                    sortTrigger++
                } else {
                    isPaused = !isPaused
                }
            }) {
                Icon(
                    imageVector = if (!isSorting || isPaused) Icons.Filled.PlayArrow else Icons.Filled.Add,
                    contentDescription = if (!isSorting || isPaused) "Start or Continue" else "Pause",
                    modifier = Modifier.size(36.dp),
                    tint = Color.Unspecified
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = {
                    if (!isSorting) {
                        values = parseInput(userInput)
                        animatedValues.clear()
                        animatedValues.addAll(values)
                        isPaused = false
                        sortTrigger++
                    }
                },
                enabled = !isSorting
            ) {
                Text("Visualize Sort 🚀")
            }
        }
    }
}

fun parseInput(input: String): List<Int> {
    return input.split(",").mapNotNull {
        it.trim().toIntOrNull()
    }
}
@Composable
fun App() {
    Box(modifier = Modifier.fillMaxSize()) {
        //AnimatedBackground()
        Grid3DBackground()
        BubbleSortTitle3D()
        BubbleSortVisualizer()
        //MainUI(modifier = Modifier.fillMaxSize())

        //ActionBar(modifier = Modifier.align(Alignment.TopCenter))
        //BubbleSortVisualizer()
    }
}
@Composable
fun BubbleSortTitle3D(modifier: Modifier = Modifier) {
    // Pulse effect to animate the title
    val pulse by rememberInfiniteTransition().animateFloat(
        initialValue = 1f,
        targetValue = 1.05f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        modifier = modifier
            .graphicsLayer(
                rotationX = 20f,
                rotationZ = -8f,
                shadowElevation = 12f,
                shape = RoundedCornerShape(4.dp),
                clip = false
            )
            .padding(top = 59.dp)
    )
    Text(
        text = "Bubble Sort",
        fontSize = 36.sp,
        fontWeight = FontWeight.ExtraBold,
        style = TextStyle(
            brush = Brush.linearGradient(
                colors = listOf(
                    Color(0xFF00F260), // bright green
                    Color(0xFF0575E6)  // blue
                )
            ),
            shadow = Shadow(
                color = Color.Cyan,
                offset = Offset(4f, 4f),
                blurRadius = 8f
            )
        ),
        modifier = Modifier
            .fillMaxWidth() // This will horizontally center the text within the Box
            .graphicsLayer(scaleX = pulse, scaleY = pulse) // Adding scale animation
            .wrapContentWidth(Alignment.CenterHorizontally) // Ensures text stays centered within the width
    )
}

@Composable
fun Grid3DBackground() {
    val infiniteTransition = rememberInfiniteTransition(label = "grid background")

    val offsetY by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(10000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ), label = "scrolling"
    )

    Canvas(modifier = Modifier.fillMaxSize()) {
        val width = size.width
        val height = size.height

        val horizonY = height / 3f
        val spacing = 40f

        // 🌀 Background with light gradient
        drawRect(
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color(0xFFB2FEFA), // Light teal
                    Color(0xFF0ED2F7), // Neon blue
                    Color(0xFF3A7BD5)  // Slightly darker blue
                ),
                startY = 0f,
                endY = height
            ),
            size = size
        )

        // ✨ Glowing neon vertical lines
        for (i in -10..10) {
            val x = width / 2f + i * spacing
            drawLine(
                color = Color(0xFF00FFFF).copy(alpha = 0.2f), // Cyan glow
                start = Offset(x, horizonY),
                end = Offset(x, height),
                strokeWidth = 1.5f
            )
        }

        // ✨ Glowing horizontal lines
        for (i in 1..40) {
            val progress = (i / 40f + offsetY) % 1f
            val y = horizonY + progress * (height - horizonY)
            drawLine(
                color = Color(0xFFB2FEFA).copy(alpha = 0.15f), // Soft teal
                start = Offset(0f, y),
                end = Offset(width, y),
                strokeWidth = 1.2f
            )
        }
    }
}