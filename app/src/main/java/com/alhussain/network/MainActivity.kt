package com.alhussain.network

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.alhussain.network.ui.theme.NetworkTheme
import com.alhussain.retrofit.datasource.AuthDataSource
import com.alhussain.retrofit.datasource.AxiomNetworkDataSource
import com.alhussain.retrofit.model.ResultWrapper
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var network: AxiomNetworkDataSource

    @Inject
    lateinit var auth: AuthDataSource
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetworkTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }



        lifecycleScope.launch {

            network.getCustomerInfoByIMEI("359457090377465")

            when (val response = network.syncDevice("19962024")) {
                is ResultWrapper.Success -> {

                }

                is ResultWrapper.GenericError -> {
                    println("Error: " + response.error?.error)
                }

                else -> {
                }
            }

//            when (val response = auth.login()) {
//                is ResultWrapper.Success -> {
//                    println("Success: " + response.value.data?.accessToken)
//
//                }
//
//                is ResultWrapper.GenericError -> {
//                    println("Error: " + response.error?.error)
//                }
//
//                else -> {
//                }
//            }


        }


    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NetworkTheme {
        Greeting("Android")
    }
}