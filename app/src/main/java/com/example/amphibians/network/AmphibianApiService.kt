/*
 * Copyright (C) 2021 The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.amphibians.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET

// TODO: Create a property for the base URL provided in the codelab
// TODO: Tạo một thuộc tính cho URL cơ sở được cung cấp trong codelab
private val BASE_URL =
    "https://developer.android.com/courses/pathways/android-basics-kotlin-unit-4-pathway-2/"

// TODO: Build the Moshi object with Kotlin adapter factory that Retrofit will be using to parse JSON
// TODO: Xây dựng Moshi object với Kotlin adapter factory mà Retrofit sẽ sử dụng để phân tích cú pháp JSON
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

// TODO: Build a Retrofit object with the Moshi converter
// TODO: Xây dựng một Retrofit object với Moshi converter
private val retrofit =
    Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

interface AmphibianApiService {
    // TODO: Declare a suspended function to get the list of amphibians
    //TODO: Khai báo một suspended function đến lấy danh sách của amphibians
    @GET("android-basics-kotlin-unit-4-pathway-2-project-api.json")
    suspend fun getAmphibians(): List<Amphibian>
}

// TODO: Create an object that provides a lazy-initialized retrofit service
// TODO: Tạo một object được cung cấp dịch vụ retrofit khởi tạo lười

object AmphibianApi {
    val retrofitService: AmphibianApiService by lazy {
        retrofit.create(AmphibianApiService::class.java)
    }
}


