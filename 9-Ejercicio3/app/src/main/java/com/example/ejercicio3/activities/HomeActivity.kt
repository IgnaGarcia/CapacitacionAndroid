package com.example.ejercicio3.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicio3.R
import com.example.ejercicio3.adapters.CategorieAdapter
import com.example.ejercicio3.adapters.PlatesBigCardAdapter
import com.example.ejercicio3.entities.Plate
import com.example.ejercicio3.entities.User
import com.example.ejercicio3.entities.getCategories
import com.example.ejercicio3.network.ApiClient
import com.example.ejercicio3.network.responses.PlateListResponse
import com.example.ejercicio3.network.responses.PlateResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity(), PlatesBigCardAdapter.OnClickPlate {
    var categorieAdapter : CategorieAdapter? = null
    var plateAdapter : PlatesBigCardAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.ThemeHome)
        setContentView(R.layout.activity_home)

        bindUserData()
        chargeCategories()
        chargePlates()

        val btnSeeMore = findViewById<TextView>(R.id.btnSeeMore)
        btnSeeMore.setOnClickListener { goToPlatesListActivity() }
    }

    //Intent a partir del click en una tarjeta del RecyclerView
    override fun onClickPlate(plateId : Int){
        val i = Intent(this@HomeActivity, PlateActivity::class.java)
        i.putExtra(PlateActivity.PLATE_KEY, plateId)
        startActivity(i)
    }

    //Intent a partir del click en "Ver más"
    fun goToPlatesListActivity(){
        val i = Intent(this@HomeActivity, PlatesListActivity::class.java)
        startActivity(i)
    }

    //Pasarle al RecyclerView los datos
    fun setPlatesAdapter(rvPlatesBig : RecyclerView, plates : List<Plate>){
        plateAdapter = PlatesBigCardAdapter(plates, this)

        rvPlatesBig.adapter = plateAdapter
        rvPlatesBig.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.HORIZONTAL, false)
    }

    //Traer los datos de la API
    private fun getPlates(rvPlatesBig : RecyclerView, tvErrorMessage : TextView){
        ApiClient.getServiceClient().getPlates()
            .enqueue(object: Callback<PlateListResponse> {
                override fun onResponse(call: Call<PlateListResponse>, response: Response<PlateListResponse>) {
                    if(response.isSuccessful){
                        rvPlatesBig.visibility = View.VISIBLE
                        tvErrorMessage.visibility = View.GONE
                        response.body()?.let{
                            setPlatesAdapter(rvPlatesBig, it.results)
                        }
                    }
                }

                override fun onFailure(call: Call<PlateListResponse>, t: Throwable) {
                    t.printStackTrace()

                    rvPlatesBig.visibility = View.GONE
                    tvErrorMessage.visibility = View.VISIBLE
                    tvErrorMessage.text = "Error al traer los datos..."
                }
            })
    }

    //Llamado a getPlates
    fun chargePlates(){
        val rvPlatesBig = findViewById<RecyclerView>(R.id.rvPlatesBig)
        val tvErrorMessage = findViewById<TextView>(R.id.tvErrorMessage)
        getPlates(rvPlatesBig, tvErrorMessage)
    }

    //Bindear los datos del usuario
    fun bindUserData(){
        val user : User = User("Igna98", "Ignacio", "Garcia Ravlic", 22, "gnachoxp@gmail.com", "Del Lazo 4476")
        val tvToolbar = findViewById<TextView>(R.id.tvToolbar)
        tvToolbar.text = user.location

        val tvGreeting = findViewById<TextView>(R.id.tvGreeting)
        tvGreeting.text = "Hola, ${user.name}"
    }

    //Traer lista de categorias y bindear con RecyclerView
    fun chargeCategories(){
        val categorieList = getCategories()
        val rvCategories = findViewById<RecyclerView>(R.id.rvCategories)
        categorieAdapter = CategorieAdapter(categorieList)

        rvCategories.adapter = categorieAdapter
        rvCategories.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.HORIZONTAL, false)
    }
}
