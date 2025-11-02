package com.example.questuserinput_049.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.questuserinput_049.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormRegistrasi(modifier: Modifier = Modifier) {

    var textNama by remember { mutableStateOf(value = "") }
    var textKota by remember { mutableStateOf(value = "") }
    var textTglLahir by remember { mutableStateOf(value = "") }
    var textRT by remember { mutableStateOf(value = "") }
    var textRW by remember { mutableStateOf(value = "") }
    var textUmur by remember { mutableStateOf(value = "") }
    var textJK by remember { mutableStateOf(value = "") }
    var checkboxSetuju by remember { mutableStateOf(value = false) }

    var nama by remember { mutableStateOf(value = "") }
    var kotaAsal by remember { mutableStateOf(value = "") }
    var tglLahir by remember { mutableStateOf(value = "") }
    var rt by remember { mutableStateOf(value = "") }
    var rw by remember { mutableStateOf(value = "") }
    var umur by remember { mutableStateOf(value = "") }
    var jenisKelamin by remember { mutableStateOf(value = "") }

    var showDialog by remember { mutableStateOf(value = false) }
    var gender: List<String> = listOf("Laki-laki", "Perempuan")

    var showDatePickerDialog by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.bekrond),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = stringResource(R.string.form),
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 45.sp,
                modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_medium))
            )

            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White.copy(alpha = 0.9f))
                    .padding(dimensionResource(R.dimen.padding_medium)),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = textNama,
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = stringResource(R.string.nama)) },
                    onValueChange = {
                        textNama = it
                    }
                )

                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))

                OutlinedTextField(
                    value = textKota,
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = stringResource(R.string.kota)) },
                    onValueChange = {
                        textKota = it
                    }
                )

                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = textTglLahir,
                        onValueChange = { },
                        readOnly = true,
                        modifier = Modifier.weight(2f),
                        label = { Text(text = stringResource(R.string.TTL)) },

                        trailingIcon = {
                            IconButton(onClick = {
                                showDatePickerDialog = true
                            }) {
                                Icon(
                                    imageVector = Icons.Default.DateRange,
                                    contentDescription = "Pilih Tanggal"
                                )
                            }
                        }
                    )
                    Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_small)))
                    OutlinedTextField(
                        value = textRT,
                        singleLine = true,
                        modifier = Modifier.weight(1f),
                        label = { Text(text = stringResource(R.string.RT)) },
                        onValueChange = { textRT = it },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                    Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_small)))
                    OutlinedTextField(
                        value = textRW,
                        singleLine = true,
                        modifier = Modifier.weight(1f),
                        label = { Text(text = stringResource(R.string.RW)) },
                        onValueChange = { textRW = it },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                }

                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))

                OutlinedTextField(
                    value = textUmur,
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = stringResource(R.string.umur)) },
                    onValueChange = { textUmur = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))

                Text(text = stringResource(R.string.jeniskelamin), modifier = Modifier.fillMaxWidth())
                Row(modifier = Modifier.fillMaxWidth()) {
                    gender.forEach { item ->
                        Row(
                            modifier = Modifier
                                .selectable(
                                    selected = textJK == item,
                                    onClick = { textJK = item }
                                )
                                .weight(1f),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = textJK == item,
                                onClick = {
                                    textJK = item
                                }
                            )
                            Text(text = item)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = checkboxSetuju,
                        onCheckedChange = { checkboxSetuju = it }
                    )
                    Text(
                        text = stringResource(R.string.agree),
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_small))
                    )
                }

                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))

                val isFormValid = textNama.isNotEmpty() && textKota.isNotEmpty() &&
                        textTglLahir.isNotEmpty() && textRT.isNotEmpty() &&
                        textRW.isNotEmpty() && textUmur.isNotEmpty() &&
                        textJK.isNotEmpty() && checkboxSetuju

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    enabled = isFormValid,
                    onClick = {
                        nama = textNama
                        kotaAsal = textKota
                        tglLahir = textTglLahir
                        rt = textRT
                        rw = textRW
                        umur = textUmur
                        jenisKelamin = textJK

                        showDialog = true
                    }
                ) {
                    Text(stringResource(R.string.submit))
                }
            }
        }
    }

    if (showDatePickerDialog) {
        DatePickerDialog(
            onDismissRequest = { showDatePickerDialog = false },

            confirmButton = {
                TextButton(
                    onClick = {
                        val selectedDateMillis = datePickerState.selectedDateMillis
                        if (selectedDateMillis != null) {
                            val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                            val dateString = formatter.format(Date(selectedDateMillis))

                            textTglLahir = dateString
                        }

                        showDatePickerDialog = false
                    }
                ) {
                    Text("OK")
                }
            },

            dismissButton = {
                TextButton(
                    onClick = {

                        showDatePickerDialog = false
                    }
                ) {
                    Text("Cancel")
                }
            }
        ) {

            DatePicker(state = datePickerState)
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(stringResource(R.string.dialog_title)) },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.spacing_small))) {
                    Text("${stringResource(R.string.dialog_label_nama)}: $nama")
                    Text("${stringResource(R.string.dialog_label_kota)}: $kotaAsal")
                    Text("${stringResource(R.string.dialog_label_tgl_lahir)}: $tglLahir")
                    Text("${stringResource(R.string.dialog_label_rt)}: $rt")
                    Text("${stringResource(R.string.dialog_label_rw)}: $rw")
                    Text("${stringResource(R.string.dialog_label_umur)}: $umur")
                    Text("${stringResource(R.string.dialog_label_jk)}: $jenisKelamin")
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        showDialog = false

                        textNama = ""
                        textKota = ""
                        textTglLahir = ""
                        textRT = ""
                        textRW = ""
                        textUmur = ""
                        textJK = ""
                        checkboxSetuju = false
                    }
                ) {
                    Text(stringResource(R.string.dialog_ok))
                }
            }
        )
    }
}