package ph.apper.android.pagatpatan.testapi.api

import ph.apper.android.pagatpatan.testapi.models.DefaultResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {

    @FormUrlEncoded
    @POST("createuser")
    fun createUser(
        @Field("email") email:String,
        @Field("password") password:String,
    ): retrofit2.Call<DefaultResponse>

}