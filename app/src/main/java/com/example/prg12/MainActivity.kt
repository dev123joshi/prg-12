package com.example.prg12

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    private lateinit var btnFetch: Button
    private lateinit var txtResult: TextView

    private val executor = Executors.newSingleThreadExecutor()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnFetch = findViewById(R.id.btnFetch)
        txtResult = findViewById(R.id.txtResult)

        btnFetch.setOnClickListener {
            fetchWeatherData()
        }
    }

    private fun fetchWeatherData() {

        btnFetch.isEnabled = false
        txtResult.text = "Loading weather information..."

        executor.execute {

            var connection: HttpURLConnection? = null

            try {
                val apiUrl =
                    "https://api.open-meteo.com/v1/forecast" +
                            "?latitude=12.9716" +
                            "&longitude=77.5946" +
                            "&current=temperature_2m,relative_humidity_2m,apparent_temperature,wind_speed_10m"

                val url = URL(apiUrl)

                connection = url.openConnection() as HttpURLConnection

                connection.requestMethod = "GET"
                connection.connectTimeout = 15000
                connection.readTimeout = 15000

                val responseCode = connection.responseCode

                if (responseCode == HttpURLConnection.HTTP_OK) {

                    val response = connection.inputStream
                        .bufferedReader()
                        .use { it.readText() }

                    val jsonObject = JSONObject(response)
                    val current = jsonObject.getJSONObject("current")

                    val temperature =
                        current.getDouble("temperature_2m")

                    val humidity =
                        current.getDouble("relative_humidity_2m")

                    val feelsLike =
                        current.getDouble("apparent_temperature")

                    val windSpeed =
                        current.getDouble("wind_speed_10m")

                    val weatherInfo = """
                        WEATHER INFORMATION
                        
                        Location: Bengaluru
                        
                        Temperature: $temperature °C
                        
                        Humidity: $humidity %
                        
                        Feels Like: $feelsLike °C
                        
                        Wind Speed: $windSpeed km/h
                        
                        HTTP Response Code: $responseCode
                        
                        Data fetched successfully!
                    """.trimIndent()

                    runOnUiThread {
                        txtResult.text = weatherInfo
                        btnFetch.isEnabled = true
                    }

                } else {

                    runOnUiThread {
                        txtResult.text =
                            "Server Error: HTTP $responseCode"
                        btnFetch.isEnabled = true
                    }
                }

            } catch (e: Exception) {

                runOnUiThread {
                    txtResult.text =
                        "Error: ${e.message}\nPlease check your internet connection."
                    btnFetch.isEnabled = true
                }

            } finally {
                connection?.disconnect()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        executor.shutdownNow()
    }
}