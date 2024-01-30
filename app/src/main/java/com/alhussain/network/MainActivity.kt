package com.alhussain.network

import android.os.Bundle
import android.widget.Toast
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
import com.alhussain.retrofit.datasource.AxiomNetworkDataSource
import com.alhussain.retrofit.fake.FakeStore
import com.alhussain.retrofit.model.ConfirmOrderRequest
import com.alhussain.retrofit.model.ResultWrapper
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var network: AxiomNetworkDataSource

    @Inject
    lateinit var fakeStore: FakeStore

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

//            val result4 = network.fulfilledOrder("POS-DING-19962024-CMRTINNDUJVFLJKDJKD0")
//            PO
            orderDingFlow()


        }


    }

    private suspend fun orderDuFlow() {
        val result1 = network.getCustomerInfoByIMEI("359457090377465")
        if (result1 is ResultWrapper.Success) {
            fakeStore.setUsername(result1.value.data?.customerId.orEmpty())
            fakeStore.setPassword(result1.value.data?.clientSecret.orEmpty())
        }
        val result2 = network.order(FakeStore.getOrderRequest())
        if (result2 is ResultWrapper.Success) {
            val result3 = network.fulfilledOrder(result2.value.reqId)

            if (result3 is ResultWrapper.Success) {
                val result4 = network.confirmOrder(
                    ConfirmOrderRequest(
                        reqId = result3.value.reqId!!,
                        cashierId = 918246313,
                        type = result3.value.data!!.type,
                        pinSerial = result3.value.data!!.items.first().pinItems.first().pinSerial!!,
                        status = "picked"
                    )
                )
                if (result4 is ResultWrapper.Success) {
                    Toast.makeText(
                        this@MainActivity,
                        "Order completed successfully ${result4.value.status}",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }

        }
    }

    private suspend fun orderDingFlow() {
        val result1 = network.getCustomerInfoByIMEI("359457090377465")
        if (result1 is ResultWrapper.Success) {
            fakeStore.setUsername(result1.value.data?.customerId.orEmpty())
            fakeStore.setPassword(result1.value.data?.clientSecret.orEmpty())
        }
        val result2 = network.dingLookup(FakeStore.getDingLookupRequest())
        if (result2 is ResultWrapper.Success) {
            val result3 = network.fulfilledDingOrder(FakeStore.getFulfilledDingOrderRequet())

            if (result3 is ResultWrapper.Success) {


                val result4 = network.fulfilledOrder(result3.value.reqId)
                if(result4 is ResultWrapper.Success){
                    println("Ding Order Success ${result4.value.data != null}")
                }
//                Toast.makeText(
//                    this@MainActivity,
//                    "Order completed successfully ${result4.value.status}",
//                    Toast.LENGTH_SHORT
//                ).show()

            }

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