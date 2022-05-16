package com.example.bottomsheetcomposeexample

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Top
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable

fun BottomSheetContent() {

    val context = LocalContext.current
    Column(modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        BottomSheetListItem(
            icon = R.drawable.ic_share,
            isChecked = true,
            onChecked = { isChecked->  },
            title = "6201 Activităţi de realizare a software-ului la comandă (software orientat client)",
            onItemClick = { title ->
                Toast.makeText(
                    context,
                    title,
                    Toast.LENGTH_SHORT
                ).show()
            })
        BottomSheetListItem(
            icon = R.drawable.ic_link,
            isChecked = true,
            onChecked = { isChecked->  },
            title = "6202 Activităţi de consultanţă în tehnologia informaţiei",
            onItemClick = { title ->
                Toast.makeText(
                    context,
                    title,
                    Toast.LENGTH_SHORT
                ).show()
            })
        BottomSheetListItem(
            icon = R.drawable.ic_edit,
            isChecked = false,
            onChecked = { isChecked->  },
            title = "6203 Activităţi de management (gestiune şi exploatare) a mijloacelor de calcul",
            onItemClick = { title ->
                Toast.makeText(
                    context,
                    title,
                    Toast.LENGTH_SHORT
                ).show()
            })
        BottomSheetListItem(
            icon = R.drawable.ic_delete,
            isChecked = false,
            onChecked = { isChecked->  },
            title = "6209 Alte activităţi de servicii privind tehnologia informaţiei",
            onItemClick = { title ->
                Toast.makeText(
                    context,
                    title,
                    Toast.LENGTH_SHORT
                ).show()
            })
    }
}

@Preview(showBackground = true)
@Composable
fun BottomSheetContentPreview() {
    BottomSheetContent()
}

@Composable
fun BottomSheetListItem(icon: Int, title: String,isChecked : Boolean,onChecked: (Boolean)-> Unit, onItemClick: (String) -> Unit) {

    val checkedState = remember { mutableStateOf(true)}
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { onItemClick(title) })
                .height(55.dp)
                .background(color = colorResource(id = R.color.colorPrimary))
                .padding(start = 15.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(painter = painterResource(id = icon), contentDescription = "Share", tint = Color.White)
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = title, color = Color.White)
            Checkbox(
                modifier = Modifier,
                checked = isChecked, onCheckedChange = {
                checkedState.value = it
                onChecked(it)
            })
        }
    }



@Preview(showBackground = true)
@Composable
fun BottomSheetListItemPreview() {
    BottomSheetListItem(icon = R.drawable.ic_share, title = "Share", onItemClick = {},isChecked = true,
        onChecked = { isChecked->  },)
}