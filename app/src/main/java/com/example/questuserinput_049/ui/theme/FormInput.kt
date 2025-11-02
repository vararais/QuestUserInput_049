package com.example.questuserinput_049.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import com.example.questuserinput_049.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormRegistrasi(modifier: Modifier = Modifier) {

    var nama by remember { mutableStateOf("") }
    var kotaAsal by remember { mutableStateOf("") }
    var tglLahir by remember { mutableStateOf("") }
    var rt by remember { mutableStateOf("") }
    var rw by remember { mutableStateOf("") }
    var umur by remember { mutableStateOf("") }

    val gender: List<String> = listOf(
        stringResource(R.string.laki_laki),
        stringResource(R.string.perempuan)
    )
    var jenisKelamin by remember { mutableStateOf(gender[0]) }

    var isSetuju by remember { mutableStateOf(false) }

    var showDialog by remember { mutableStateOf(false) }

    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    val dateFormatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    Column(
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_default))
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.form),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_medium))
        )

        OutlinedTextField(
            value = nama,
            onValueChange = { nama = it },
            label = { Text(stringResource(R.string.nama)) },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.form_vertical_spacing)))

        OutlinedTextField(
            value = kotaAsal,
            onValueChange = { kotaAsal = it },
            label = { Text(stringResource(R.string.kota)) },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.form_vertical_spacing)))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = tglLahir,
                onValueChange = { },
                label = { Text(stringResource(R.string.TTL)) },
                modifier = Modifier
                    .weight(1f)
                    .clickable { showDatePicker = true },
                readOnly = true,
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Filled.DateRange,
                        contentDescription = "Pilih Tanggal",
                        modifier = Modifier.clickable { showDatePicker = true }
                    )
                }
            )
            Spacer(modifier = Modifier.width(dimensionResource(R.dimen.spacing_small)))

            OutlinedTextField(
                value = rt,
                onValueChange = { rt = it },
                label = { Text(stringResource(R.string.RT)) },
                modifier = Modifier.width(dimensionResource(R.dimen.rt_rw_width)),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true
            )
            Spacer(modifier = Modifier.width(dimensionResource(R.dimen.spacing_small)))

            OutlinedTextField(
                value = rw,
                onValueChange = { rw = it },
                label = { Text(stringResource(R.string.RW)) },
                modifier = Modifier.width(dimensionResource(R.dimen.rt_rw_width)),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true
            )
        }
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.form_vertical_spacing)))

        OutlinedTextField(
            value = umur,
            onValueChange = { umur = it },
            label = { Text(stringResource(R.string.umur)) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.form_vertical_spacing)))

        Text(
            text = stringResource(R.string.jeniskelamin),
            modifier = Modifier.align(Alignment.Start)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            gender.forEach { text ->
                Row(
                    modifier = Modifier
                        .selectable(
                            selected = (jenisKelamin == text),
                            onClick = { jenisKelamin = text }
                        )
                        .padding(end = dimensionResource(R.dimen.padding_medium)),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (jenisKelamin == text),
                        onClick = { jenisKelamin = text }
                    )
                    Text(text = text, modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_small)))
                }
            }
        }
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacing_small)))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .selectable(
                    selected = isSetuju,
                    onClick = { isSetuju = !isSetuju }
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isSetuju,
                onCheckedChange = { isSetuju = it }
            )
            Text(
                text = stringResource(R.string.agree),
                modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_small))
            )
        }
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))

        Button(
            onClick = {
                showDialog = true
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = isSetuju
        ) {
            Text(stringResource(R.string.submit))
        }
    }
    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                Button(
                    onClick = {
                        val selectedDateMillis = datePickerState.selectedDateMillis
                        if (selectedDateMillis != null) {
                            tglLahir = dateFormatter.format(Date(selectedDateMillis))
                        }
                        showDatePicker = false
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                Button(onClick = { showDatePicker = false }) {
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
                    Text("${stringResource(R.string.dialog_label_alamat)}: $kotaAsal")
                    Text("${stringResource(R.string.dialog_label_tgl_lahir)}: $tglLahir")
                    Text("${stringResource(R.string.dialog_label_rt)}: $rt")
                    Text("${stringResource(R.string.dialog_label_rw)}: $rw")
                    Text("${stringResource(R.string.dialog_label_umur)}: $umur")
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        showDialog = false

                        nama = ""
                        kotaAsal = ""
                        tglLahir = ""
                        rt = ""
                        rw = ""
                        umur = ""
                        jenisKelamin = gender[0]
                        isSetuju = false
                    }
                ) {
                    Text(stringResource(R.string.dialog_ok))
                }
            }
        )
    }
}
