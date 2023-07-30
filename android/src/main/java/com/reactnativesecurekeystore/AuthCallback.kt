import android.hardware.biometrics.BiometricPrompt
import android.hardware.biometrics.BiometricPrompt.CryptoObject
import android.os.Build
import androidx.annotation.RequiresApi


@RequiresApi(Build.VERSION_CODES.P)
class BiometricPromptAuthCallback (
  val onSuccess: (cryptoObject: CryptoObject) -> Unit,
  val onFailure: (errorCode: Int, errString: String) -> Unit
) : BiometricPrompt.AuthenticationCallback() {
  override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
    super.onAuthenticationError(errorCode, errString)

    onFailure(errorCode, errString.toString())
  }

  override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
    super.onAuthenticationSucceeded(result)

    onSuccess(result.cryptoObject)
  }
}
