package mchehab.com.picassotransformationoverview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import jp.wasabeef.picasso.transformations.*
import jp.wasabeef.picasso.transformations.gpu.InvertFilterTransformation
import jp.wasabeef.picasso.transformations.gpu.PixelationFilterTransformation
import jp.wasabeef.picasso.transformations.gpu.SwirlFilterTransformation
import jp.wasabeef.picasso.transformations.gpu.ToonFilterTransformation
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val IMAGE_URL = "http://wallpaper-gallery.net/images/image/image-19.jpg"

        val listImageTransform = ArrayList<ImageTransform>()
        listImageTransform.add(ImageTransform(IMAGE_URL, CropCircleTransformation()))
        listImageTransform.add(ImageTransform(IMAGE_URL, CropSquareTransformation()))
        listImageTransform.add(ImageTransform(IMAGE_URL, CropTransformation(250, 250, 0, 0)))
        listImageTransform.add(ImageTransform(IMAGE_URL, BlurTransformation(this)))
        listImageTransform.add(ImageTransform(IMAGE_URL, ToonFilterTransformation(this)))
        listImageTransform.add(ImageTransform(IMAGE_URL, InvertFilterTransformation(this)))
        listImageTransform.add(ImageTransform(IMAGE_URL, PixelationFilterTransformation(this)))
        listImageTransform.add(ImageTransform(IMAGE_URL, GrayscaleTransformation()))
        listImageTransform.add(ImageTransform(IMAGE_URL, SwirlFilterTransformation(this)))

        val listView = findViewById<ListView>(R.id.listView)
        val listViewAdapter = ListViewAdapter(this, listImageTransform)

        listView.adapter = listViewAdapter
    }
}
