package com.example.clase201

import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clase201.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SampleItem : AppCompatActivity(), UsersAdapter.OnClickUser {
    var usersAdapter : UsersAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvUser = findViewById<RecyclerView>(R.id.rvUser)
        val tvMessage = findViewById<TextView>(R.id.tvMessage)
        getUsers(rvUser, tvMessage)


    }

    fun setUsersAdapter(rvUsers : RecyclerView, users : List<User>){
        usersAdapter = UsersAdapter(users, this)

        rvUsers.adapter = usersAdapter
        rvUsers.layoutManager = LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false)
    }

    override fun onClickUser(username : String){
        val i = Intent(this@SampleItem, DetailActivity::class.java)
        i.putExtra(DetailActivity.USER_KEY, username)
        startActivity(i)
    }

    private fun getUsers(rvUsers : RecyclerView, tvMessage: TextView){
        ApiClient.getServiceClient().getUsers()
            .enqueue(object: Callback<List<User>>{
                override fun onFailure(call : Call<List<User>>, t: Throwable){
                    //log
                    t.printStackTrace()

                    rvUsers.visibility = View.GONE
                    tvMessage.visibility = View.VISIBLE
                    tvMessage.text = "Error"
                }

                override fun onResponse(call : Call<List<User>>, response : Response<List<User>>){
                    if(response.isSuccessful){
                        if(response.body().isNullOrEmpty()){
                            rvUsers.visibility = View.GONE
                            tvMessage.visibility = View.VISIBLE
                            tvMessage.text = "No hay usuarios"
                        }else{
                            rvUsers.visibility = View.VISIBLE
                            tvMessage.visibility = View.GONE
                            response.body()?.let{
                                setUsersAdapter(rvUsers, it)
                            }
                        }
                    }
                }
            })
    }
}