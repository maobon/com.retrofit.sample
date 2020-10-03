package com.retrofit.kotlin

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.retrofit.Constants
import com.retrofit.kotlin.model.BeanList
import com.retrofit.kotlin.retrofit.ApiKotlinService
import com.retrofit.kotlin.retrofit.ApiSampleService
import com.retrofit.kotlin.retrofit.RetrofitKotlinBuilder
import com.retrofit.sample.R
import kotlinx.android.synthetic.main.fragment_second.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KotlinFragment : Fragment() {

    val TAG = "KotlinFragment"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        val retrofit = RetrofitKotlinBuilder().getRetrofitInstance(requireActivity())
        val requestService = retrofit.create(ApiKotlinService::class.java)

        btn_send_get_request.setOnClickListener {
            // val call = requestService.getRequestData(Constants.API_KEY, Constants.API_VERSION, Constants.MONTH, Constants.DAY)

            val sampleService = ApiSampleService.create()
            val call = sampleService.getRequestData(Constants.API_KEY, Constants.API_VERSION, Constants.MONTH, Constants.DAY)

            resultHandler(call)
        }

        btn_send_post_request.setOnClickListener {
            val call = requestService.postRequestData(Constants.API_KEY, Constants.API_VERSION, Constants.MONTH, Constants.DAY)
            resultHandler(call)
        }

        btn_to_java.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

    private fun resultHandler(call: Call<BeanList>) {

        call.enqueue(object : Callback<BeanList> {

            override fun onResponse(call: Call<BeanList>, response: Response<BeanList>) {

                val data = response.body()?.list
                val resp = data!!

                for (item in resp) {
                    Log.wtf(TAG, "item:$item")
                }
            }

            override fun onFailure(call: Call<BeanList>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}