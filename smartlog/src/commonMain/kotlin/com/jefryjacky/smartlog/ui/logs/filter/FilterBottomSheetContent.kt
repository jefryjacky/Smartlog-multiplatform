package com.jefryjacky.smartlog.ui.logs.filter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jefryjacky.smartlog.LogLevel
import com.jefryjacky.smartlog.ui.component.DropdownMenu
import com.jefryjacky.smartlog.ui.logLevelMap
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import smartlogginapp.smartlog.generated.resources.Res
import smartlogginapp.smartlog.generated.resources.apply
import smartlogginapp.smartlog.generated.resources.log_level
import smartlogginapp.smartlog.generated.resources.reset
import smartlogginapp.smartlog.generated.resources.search

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterBottomSheetContent(
    state: FilterBottomState,
    event: (FilterEvent)->Unit
) {
    val sheetState = rememberModalBottomSheetState()
    val showBottomSheet by remember(state.isOpen){ derivedStateOf { state.isOpen } }
    if(showBottomSheet) {
        ModalBottomSheet(onDismissRequest = {
            event(FilterEvent.DismissEvent)
        },
            sheetState = sheetState, content = {
            Content(state, event)
        })
    }
}

@Composable
private fun Content(
    state: FilterBottomState,
    event: (FilterEvent)->Unit){
    Column(modifier = Modifier.fillMaxSize()
        .padding(16.dp)) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.search,
            label = {
                Text(stringResource(Res.string.search))
            }, onValueChange = {
                event(FilterEvent.SearchEvent(it))
            })
        Spacer(Modifier.height(8.dp))
        DropdownMenu(
            label = stringResource(Res.string.log_level),
            value = "",
            modifier = Modifier.fillMaxWidth(),
            list = logLevelMap.toList()
                .map {
                    Pair(it.first, stringResource(it.second))
                },
        ){
            event(FilterEvent.LogLevelChanged(it))
        }
        Spacer(Modifier.height(8.dp))
        Row() {
            Button(
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(6.dp),
                onClick = {
                    event(FilterEvent.ResetEvent)
                }){
                Text(stringResource(Res.string.reset))
            }
            Spacer(Modifier.width(8.dp))
            Button(
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(6.dp),
                onClick = {
                    event(FilterEvent.Apply)
                }){
                Text(stringResource(Res.string.apply))
            }
        }
    }
}

@Preview
@Composable
private fun ContentPreview(){
    val state = FilterBottomState()
    Content(state){}
}