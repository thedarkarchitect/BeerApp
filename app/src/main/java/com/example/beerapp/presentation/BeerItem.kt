package com.example.beerapp.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.beerapp.domain.model.Beer
import com.example.beerapp.ui.theme.BeerAppTheme

@Composable
fun BeerItem(
    beer: Beer,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(4.dp)
    ) {

        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)//this can refer to height or width an push the row depending on how it fit
                .padding(16.dp)
        ) {
            AsyncImage(
                model = beer.imageUrl,
                contentDescription = beer.name,
                modifier = modifier
                    .weight(1f)
                    .height(150.dp)
            )

            Column(
                modifier = modifier
                    .weight(3f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = beer.name,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = modifier.fillMaxWidth()
                )
                Spacer(modifier = modifier.height(8.dp))
                Text(
                    text = beer.tagline,
                    color = Color.LightGray,
                    fontStyle = FontStyle.Italic,
                    modifier = modifier.fillMaxWidth()
                )
                Spacer(modifier = modifier.height(8.dp))
                Text(
                    text = beer.description,
                    modifier = modifier.fillMaxWidth()
                )
                Spacer(modifier = modifier.height(8.dp))
                Text(
                    text = "First brewed in ${beer.firstbrewed}",
                    modifier = modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                    fontSize = 8.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun BeerItemPreview() {
    BeerAppTheme {
        BeerItem(
            beer = Beer(
                id = 1,
                name = "Beer",
                tagline = "This is a cold Beer",
                firstbrewed = "18/10/2023",
                description = "This is a description for a beer. \nThis is the next line.",
                imageUrl = null
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}
