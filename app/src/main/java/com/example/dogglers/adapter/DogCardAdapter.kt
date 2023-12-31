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
package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.const.Layout
import com.example.dogglers.data.DataSource
import com.example.dogglers.model.Dog

class DogCardAdapter(
    private val context: Context?,
    private val layout: Int,
    private val dataset: List<Dog> = DataSource.dogs
): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    class DogCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        val dogImage: ImageView? = view?.findViewById(R.id.dogImageView)
        val textName: TextView? = view?.findViewById(R.id.textDogName)
        val textAge: TextView? = view?.findViewById(R.id.textDogAge)
        val textHobbies: TextView? = view?.findViewById(R.id.textDogHobbies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {

        var adapterLayout = when (viewType) {
            1 -> LayoutInflater.from(parent.context).inflate(R.layout.vertical_horizontal_list_item, parent, false)
            2 -> LayoutInflater.from(parent.context).inflate(R.layout.vertical_horizontal_list_item, parent, false)
            else -> LayoutInflater.from(parent.context).inflate(R.layout.grid_list_item, parent, false)
        }

        return DogCardViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
      return dataset.size
    }

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        val item = dataset[position]
        holder.dogImage?.setImageResource(item.imageResourceId)
        holder.textName?.text = item.name
        holder.textAge?.text = item.age
        holder.textHobbies?.text = item.hobbies
    }
}
