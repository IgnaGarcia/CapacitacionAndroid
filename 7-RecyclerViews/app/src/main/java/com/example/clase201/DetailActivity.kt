package com.example.clase201

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.clase201.network.ApiClient
import com.example.clase201.network.responses.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity: AppCompatActivity() {
    companion object{
        const val USER_KEY = "user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_user)

        val username = intent.extras?.getString(USER_KEY)
        val tvName = findViewById<TextView>(R.id.tvName)
        getUserDetails(tvName, username!!)
    }

    private fun getUserDetails(tvName : TextView, username : String){
        ApiClient.getServiceClient().getUserDetails(username)
            .enqueue(object: Callback<UserResponse> {
                override fun onFailure(call : Call<UserResponse>, t: Throwable){
                    //log
                    t.printStackTrace()

                    tvName.text = "Error"
                }

                override fun onResponse(call : Call<UserResponse>, response : Response<UserResponse>){
                    if(response.isSuccessful){
                        response.body()?.let{
                            println("${it.login} - ${it.type} - ${it.siteAdmin} - ${it.avatarUrl}")
                            val tvIsSiteAdmin = findViewById<TextView>(R.id.tvIsSiteAdmin)
                            val tvType = findViewById<TextView>(R.id.tvType)
                            val ivProfile = findViewById<ImageView>(R.id.ivProfile)

                            tvName.text = it.login
                            tvType.text = it.type
                            tvIsSiteAdmin.text = if(it.siteAdmin) "Es admin" else "No es admin"
                            Glide.with(ivProfile.context).load(it.avatarUrl)
                                .circleCrop().into(ivProfile)
                        }
                    }
                }
            })
    }
}