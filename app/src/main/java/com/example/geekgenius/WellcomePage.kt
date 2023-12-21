package com.example.geekgenius

import android.content.ContentProviderClient
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.Intent
import android.widget.Toast
import com.example.geekgenius.databinding.ActivityWellcomePageBinding
import com.geek.app.ui.main.MainActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider


class WellcomePage : AppCompatActivity() {

    private lateinit var binding: ActivityWellcomePageBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var googleApiClient: GoogleApiClient
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityWellcomePageBinding.inflate(layoutInflater)
        firebaseAuth = FirebaseAuth.getInstance()

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        binding.btnLoginGoogle.setOnClickListener() {
            signWithGoogle()
        }
        binding.btnLoginEmail.setOnClickListener {
            startActivity(Intent(this, LoginPage::class.java))
        }
        binding.linkRegister.setOnClickListener {
            startActivity(Intent(this, RegisterPage::class.java))
        }
    }

    private fun signWithGoogle() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleGoogleSignInResult(task)
        }
    }

    private fun handleGoogleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            firebaseAuthWithGoogle(account!!)
        } catch (e: ApiException) {
            // Handle sign in failure
            // ...
        }
    }

    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        val credential: AuthCredential = GoogleAuthProvider.getCredential(acct.idToken, null)

        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Berhasil Masuk Dengan Google", Toast.LENGTH_SHORT).show()
                    val user = firebaseAuth.currentUser
                    startActivity(Intent(this, DashboardPage::class.java))
                } else {
                    Toast.makeText(this, "Autentikasi Gagal", Toast.LENGTH_SHORT).show()
                    // If sign in fails, display a message to the user.
                    // ...
                }
            }
    }

    companion object {
        private const val RC_SIGN_IN = 123
    }

}