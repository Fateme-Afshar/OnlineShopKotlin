package com.utab.onlineshopkotlin.utils

class NetworkUtils {
    companion object{
        const val BASE_URL="https://woocommerce.maktabsharif.ir/wp-json/wc/v3/"

        fun mapKey():Map<String,String>{
            val map= mutableMapOf<String,String>()
            map["consumer_key"]="ck_373d2b7f68efab7ceba67788d017dfcc8e80cab6"
            map["consumer_secret"]="cs_45ceb9de983308785f5affc3b5648a48101b4b67"

            return map
        }
    }
}