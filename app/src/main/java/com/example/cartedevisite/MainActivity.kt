package com.example.cartedevisite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cartedevisite.ui.theme.CarteDeVisiteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            CarteDeVisiteTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF2E6C8C)
                ) {
                    BusinessCardScreen(
                        name = stringResource(R.string.name),
                        title = stringResource(R.string.mobile),
                        company = stringResource(R.string.function),
                        phone = stringResource(R.string.number),
                        email = stringResource(R.string.email),
                        location = stringResource(R.string.location)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCardScreen(
    name: String,
    title: String,
    company: String,
    phone: String,
    email: String,
    location: String
) {
    // Colonne principale
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2E6C8C)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Colonne du haut (prenant de l'espace pour centrer le contenu)
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = "Logo Android",
                modifier = Modifier.size(120.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = name,
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = title,
                color = Color(0xFF3DDC84),
                fontSize = 18.sp
            )
            Text(
                text = company,
                color = Color.White,
                fontSize = 14.sp
            )
        }

        // Section des contacts (alignée en bas)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 130.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Column {
                ContactInfoItem(icon = Icons.Default.Phone, text = phone)
                ContactInfoItem(icon = Icons.Default.Email, text = email)
                ContactInfoItem(icon = Icons.Default.Place, text = location)
            }
        }
    }
}

@Composable
fun ContactInfoItem(icon: ImageVector, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            tint = Color(0xFF3DDC84),
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = text, color = Color.White, fontSize = 16.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun CarteDeVisitePreview() {
    CarteDeVisiteTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFF2E6C8C)
        ) {
            BusinessCardScreen(
                name = stringResource(R.string.namePreview),
                title = stringResource(R.string.mobilePreview),
                company = stringResource(R.string.functionPreview),
                phone = stringResource(R.string.numberPreview),
                email = stringResource(R.string.emailPreview),
                location = stringResource(R.string.locationPreview)
            )
        }
    }
}