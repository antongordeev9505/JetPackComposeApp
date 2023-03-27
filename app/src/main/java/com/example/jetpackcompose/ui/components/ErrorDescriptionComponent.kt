package com.example.jetpackcompose.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withAnnotation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.R

@OptIn(ExperimentalTextApi::class)
@Composable
fun ErrorDescriptionComponent(
    mainText: String = "Ooops, error!",
    prefix: String = "Error code: ",
    suffix: String = "AA-31",
    onTextClickAction: (String) -> Unit = {},
    mainModifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = mainModifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_baseline_error_24),
            contentDescription = "Error picture",
            modifier = Modifier
                .fillMaxSize(0.5f)
                .clip(RoundedCornerShape(25))
                .border(
                    border = BorderStroke(
                        width = 8.dp,
                        color = MaterialTheme.colors.primary
                    ),
                    shape = RoundedCornerShape(25)
                )
        )

        Text(
            text = mainText,
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 4.dp)
        )

        Text(
            text = buildAnnotatedString {
                append(prefix)
                withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(suffix)
                }
            },
            modifier = Modifier.padding(vertical = 4.dp)
        )

        val annotatedString = buildAnnotatedString {
            append("Want to help? ")
            append("Contact us: ")
            withStyle(
                SpanStyle(
                    textDecoration = TextDecoration.Underline,
                    color = MaterialTheme.colors.primary
                )
            ) {
                withAnnotation(
                    tag = "Error tag",
                    annotation = "webLink.com"
                ) {
                    append("support")
                }
            }
        }

        ClickableText(
            text = annotatedString,
            onClick = { offset ->
                annotatedString.getStringAnnotations(
                    tag = "Error tag",
                    start = offset,
                    end = offset
                ).firstOrNull()?.let { annotation ->
                    onTextClickAction(annotation.item)
                }
            },
            style = TextStyle.Default.merge(
                TextStyle(
                    textAlign = TextAlign.Center,
                )
            ),
            modifier = Modifier.padding(vertical = 4.dp)
        )
    }
}