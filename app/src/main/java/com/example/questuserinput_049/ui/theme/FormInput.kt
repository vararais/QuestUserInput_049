package com.example.questuserinput_049.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.questuserinput_049.R

@Composable
fun FormRegistrasi(modifier: Modifier = Modifier) {

    var nama by remember { mutableStateOf("") }
    var kotaAsal by remember { mutableStateOf("") }
    var TTL by remember { mutableStateOf("") }
    var RT by remember { mutableStateOf("") }
    var RW by remember { mutableStateOf("") }
    var umur by remember { mutableStateOf("") }

    var jenisKelamin: List<String> = listOf("Laki-laki","Perempuan")

    var isSetuju by remember { mutableStateOf(false) }

    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_default)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


    }
}