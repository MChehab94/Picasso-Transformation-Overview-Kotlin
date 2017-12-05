package mchehab.com.picassotransformationoverview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView

import com.squareup.picasso.Picasso

/**
 * Created by muhammadchehab on 12/5/17.
 */

class ListViewAdapter(private val context: Context, private val listImageTransform: List<ImageTransform>) : BaseAdapter() {

    override fun getCount(): Int {
        return listImageTransform.size
    }

    override fun getItem(position: Int): Any {
        return listImageTransform[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val viewHolder: ViewHolder
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_row, null)

            viewHolder = ViewHolder()
            viewHolder.imageView = convertView!!.findViewById(R.id.imageView)

            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ViewHolder
        }
        val (imageURL, transformation) = listImageTransform[position]
        Picasso.with(context)
                .load(imageURL)
                .transform(transformation)
                .into(viewHolder.imageView)

        return convertView
    }

    internal inner class ViewHolder {
        var imageView: ImageView? = null
    }
}