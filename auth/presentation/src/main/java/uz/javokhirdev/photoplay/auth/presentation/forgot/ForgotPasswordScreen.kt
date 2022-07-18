package uz.javokhirdev.photoplay.auth.presentation.forgot

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import uz.javokhirdev.photoplay.auth.presentation.components.EmailInput
import uz.javokhirdev.photoplay.core.R
import uz.javokhirdev.photoplay.coreui.Gray
import uz.javokhirdev.photoplay.coreui.LocalSpacing
import uz.javokhirdev.photoplay.coreui.components.ActionButton
import uz.javokhirdev.photoplay.coreui.components.BackButton
import uz.javokhirdev.photoplay.coreui.components.BigImageLogo

@Composable
fun ForgotPasswordScreen(
    viewModel: ForgotViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val uiState = viewModel.uiState.collectAsState().value

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            BackButton()
        }
        item {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        vertical = 20.dp,
                        horizontal = 40.dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                BigImageLogo()
                Spacer(modifier = Modifier.height(spacing.spaceLarge))
                Text(
                    text = stringResource(id = R.string.forgot_password).uppercase(),
                    style = MaterialTheme.typography.h4,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = stringResource(id = R.string.send_email_description),
                    style = MaterialTheme.typography.body1,
                    color = Gray,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(spacing.spaceLarge))
                EmailInput(
                    email = uiState.email.orEmpty(),
                    onEmailChanged = {
                        viewModel.handleEvent(ForgotEvent.EmailChanged(it))
                    }
                )
                Spacer(modifier = Modifier.height(spacing.spaceMedium))
                ActionButton(
                    text = stringResource(id = R.string.send_email),
                    onClick = { viewModel.handleEvent(ForgotEvent.OnSendClick) }
                )
            }
        }
    }
}