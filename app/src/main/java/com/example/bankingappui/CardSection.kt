package com.example.bankingappui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingappui.data.Card
import com.example.bankingappui.ui.theme.BlueEnd
import com.example.bankingappui.ui.theme.BlueStart
import com.example.bankingappui.ui.theme.GreenEnd
import com.example.bankingappui.ui.theme.GreenStart
import com.example.bankingappui.ui.theme.OrangeEnd
import com.example.bankingappui.ui.theme.OrangeStart
import com.example.bankingappui.ui.theme.PurpleEnd
import com.example.bankingappui.ui.theme.PurpleStart

val cards = listOf(
    Card(
        cardType = "VISA",
        cardNumber = "3665 3255 2345 6788",
        cardName = "Business",
        balance = 334.45,
        color = getGradient(PurpleStart, PurpleEnd)
    ),
    Card(
        cardType = "MASTERCARD",
        cardNumber = "1355 3456 6543 1290",
        cardName = "Savings",
        balance = 4533.45,
        color = getGradient(BlueStart, BlueEnd)
    ),
    Card(
        cardType = "VISA",
        cardNumber = "1245 6343 9023 1235",
        cardName = "School",
        balance = 152.35,
        color = getGradient(OrangeStart, OrangeEnd)
    ),
    Card(
        cardType = "MASTERCARD",
        cardNumber = "2356 2567 8765 2344",
        cardName = "Travel",
        balance = 36789.45,
        color = getGradient(GreenStart, GreenEnd)
    ),
)

fun getGradient(
    startColor: Color,
    endColor: Color
): Brush{
    return Brush.horizontalGradient(
        colors = listOf(startColor,endColor)
    )
}

@Composable
fun CardSection() {
    LazyRow {
        items(cards.size){index ->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(
     index: Int
) {
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if(index == cards.size - 1){
        lastItemPaddingEnd = 16.dp
    }

    var image = painterResource(id = R.drawable.ic_visa)
    if(card.cardType == "MASTERCARD"){
        image = painterResource(id = R.drawable.ic_mastercard)
    }

    Box(modifier = Modifier.padding(start = 16.dp, end = lastItemPaddingEnd)){
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable {}
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier.width(60.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,

            )

            Text("$ ${card.balance}",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,

                )

            Text(card.cardNumber,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,

                )
        }
    }
}