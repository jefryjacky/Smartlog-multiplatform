package com.jefryjacky.smartlog.ui.component

import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import smartlogginapp.smartlog.generated.resources.Res
import smartlogginapp.smartlog.generated.resources.outline_keyboard_arrow_down_24

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropwdownMenu(
    label:String,
    value: String,
    modifier: Modifier,
    list: List<String>,
    supportingText: String = "",
    isError: Boolean = false,
    selectedCallback: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    Column {
        ExposedDropdownMenuBox(
            modifier = modifier,
            expanded = expanded,
            onExpandedChange = {
                expanded = it
            }) {
            TextField(
                modifier = Modifier.menuAnchor().fillMaxWidth(),
                label = { Text(label) },
                trailingIcon = {
                    Icon(
                        painter = painterResource(Res.drawable.outline_keyboard_arrow_down_24),
                        contentDescription = "icon dropdown"
                    )
                },
                value = value, readOnly = true, onValueChange = {

                })
            ExposedDropdownMenu(
                modifier = Modifier.heightIn(max = 280.dp).fillMaxWidth(),
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                },
            ) {
                list.forEach {
                    DropdownMenuItem(
                        text = { Text(it, style = MaterialTheme.typography.bodyLarge) },
                        onClick = {
                            selectedCallback.invoke(it)
                            expanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                    )
                }
            }
        }
        val color = if (isError) MaterialTheme.colorScheme.error
        else MaterialTheme.colorScheme.onSurfaceVariant
        if(supportingText.isNotEmpty()) {
            Spacer(Modifier.height(8.dp))
            Text(text = supportingText, color = color)
        }
    }
}

@Composable
@Preview
private fun DropdownMenuPreview(){
    DropwdownMenu(
        modifier = Modifier.fillMaxWidth(),
        label = "From",
        list = listOf("USD", "IDR"),
        supportingText = "Select currency",
        value = "USD",
        isError = true
    ) { }
}