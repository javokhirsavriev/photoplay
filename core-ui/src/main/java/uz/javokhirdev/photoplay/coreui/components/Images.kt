package uz.javokhirdev.photoplay.coreui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import uz.javokhirdev.photoplay.core.R

@Composable
fun BigLogo() {
    Image(
        painter = painterResource(R.drawable.logo),
        contentDescription = "Logo",
        modifier = Modifier.height(160.dp)
    )
}

@ExperimentalCoilApi
@Composable
fun BottomGradientImage(
    modifier: Modifier = Modifier,
    imageUrl: String,
    height: Dp = 480.dp
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
    ) {
        Image(
            painter = rememberImagePainter(
                data = imageUrl,
                builder = {
                    crossfade(true)
                }
            ),
            contentDescription = "Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            Color.Transparent,
                            MaterialTheme.colors.background.copy(0.25f),
                            MaterialTheme.colors.background
                        )
                    )
                )
        )
    }
}