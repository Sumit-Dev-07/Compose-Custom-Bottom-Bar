package com.app.composebottombar.custom_navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.app.composebottombar.R

@Composable
fun CustomBottomNavigation(
    selectedItem: Int,
    onItemSelected: (Int) -> Unit
) {
    val items = listOf(
        NavigationItem("Home", R.drawable.home_active, R.drawable.home_inactive),
        NavigationItem("Search", R.drawable.search_active, R.drawable.search_inactive),
        NavigationItem("Cart", R.drawable.cart_active, R.drawable.cart_inactive),
        NavigationItem("Favorite", R.drawable.fav_active, R.drawable.fav_inactive),
        NavigationItem("Profile", R.drawable.user_active, R.drawable.user_inactive)
    )

    val orangeColor = Color(0xFFE64A19)
    val grayColor = Color(0xFF9E9E9E)

    val boxHeight = 102.dp
    val bottomBarHeight = 80.dp
    val cornerRadius = 24.dp
    val innerPadding = 12.dp

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .padding(bottom = 24.dp, start = 16.dp, end = 16.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        // Outer glow/border layer
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(boxHeight)
                .clip(RoundedCornerShape(cornerRadius))
                .background(Color.White.copy(alpha = 0.2f))
                .border(
                    1.dp,
                    Color.White.copy(alpha = 0.3f),
                    RoundedCornerShape(cornerRadius),
                )
        )

        // Main white bar
        Row(
            modifier = Modifier
                //.padding(horizontal = 6.dp, vertical = 6.dp)
                .fillMaxWidth()
                .padding(innerPadding)
                .height(bottomBarHeight)
                .clip(RoundedCornerShape(cornerRadius))
                .background(Color.White),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEachIndexed { index, item ->
                val isSelected = selectedItem == index
                CustomBottomNavItem(
                    icon = painterResource(id = if (isSelected) item.selectedIcon else item.unselectedIcon),
                    label = item.label,
                    isSelected = isSelected,
                    selectedColor = orangeColor,
                    unselectedColor = grayColor,
                    onClick = { onItemSelected(index) }
                )
            }
        }
    }
}