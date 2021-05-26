package com.google.ar.core.examples.java.helloar.placeholder

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.annotation.DrawableRes
import com.google.ar.core.examples.java.helloar.R
import com.google.ar.core.examples.java.helloar.ui.cart.CartItem
import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 */
object PlaceholderContent {

    /**
     * An array of sample (placeholder) items.
     */
    val ITEMS: MutableList<PlaceholderItem> = ArrayList()

    /**
     * A map of sample (placeholder) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, PlaceholderItem> = HashMap()

    private val COUNT = 5
    private lateinit var localBitmap:Bitmap

    var bitmap:Bitmap
        get() {
            return localBitmap
        }
        set(value) {
            localBitmap = value.copy(value.config,false)
        }

    init {
        // Add some sample items.
//        for (i in 1..COUNT) {
//            addItem(createPlaceholderItem(i))
//        }
        addItem(PlaceholderItem("1", "Red Balloon ", "In 1922 the legendary artist Paul Klee painted The Red Balloon. The colourful show of seemingly floating geometric shapes in the air, provides a unique picture.", R.drawable.daisy,
            99.9F,"https://i1.wp.com/bookmypainting.com/wp-content/uploads/2020/09/c573c68439d6c187c5f5afa7dc492a3d.jpg?resize=455%2C450&ssl=1"))
        addItem(PlaceholderItem("2", "Mona Lisa ", "The Mona Lisa is a drawing of a half-length portrait by Italian artist Leonardo da Vinci.", R.drawable.daisy,
            89.9F,"https://i2.wp.com/bookmypainting.com/wp-content/uploads/2019/06/WhatssospecialabouttheMonaLisa_.jpg?resize=600%2C875&ssl=1"))
        addItem(PlaceholderItem("3", "Starry Night ", "The Starry Night is an= famous oil painting on canvas by the post-impressionist Dutch painter Vincent van Gogh. ", R.drawable.daisy,
            79.9F,"https://i1.wp.com/bookmypainting.com/wp-content/uploads/2020/06/VG485-1000x1000-1.jpg?resize=542%2C451&ssl=1"))
        addItem(PlaceholderItem("4", "Scream ", "The Scream is the famous name of a composition produced in 1893 by Norwegian Expressionist artist Edvard Munch.", R.drawable.daisy,
            69.9F,"https://i1.wp.com/bookmypainting.com/wp-content/uploads/2019/06/the-scream-famous-painting-2.jpeg?resize=478%2C604&ssl=1"))
        addItem(PlaceholderItem("5", "Creation of Adam ", "The Creation of Adam is a fresco painting by Italian artist Michelangelo which forms part of the ceiling of the Sistine Chapel. ", R.drawable.daisy,
            59.9F,"https://i2.wp.com/bookmypainting.com/wp-content/uploads/2019/09/The_Creation_of_Adam.jpg?resize=567%2C260&ssl=1"))
        addItem(PlaceholderItem("6", "Napoleon Crossing The Alps", "Napoleon Crossing the Alps is one of five versions of Napoleon Bonaparte ‘s famous oil painting on canvas equestrian portrait, painted by the French artist Jacques-Louis David between 1801 and 1805.", R.drawable.daisy,
            49.9F,"https://i2.wp.com/bookmypainting.com/wp-content/uploads/2019/06/napoleon-crossing-the-alps-2.jpeg?resize=515%2C628&ssl=1"))
        addItem(PlaceholderItem("7", "Storm On The Sea", "The Storm at the Sea of Galilee is a famous oil painting by Rembrandt van Rijn, the Dutch Golden Age painter. ", R.drawable.daisy,
            39.9F,"https://i0.wp.com/bookmypainting.com/wp-content/uploads/2020/09/storm-1000x658-1.jpg?resize=446%2C294&ssl=1"))
        addItem(PlaceholderItem("8", "Composition VIII", "Composition VIII, created in 1923 by Russian artist Wassily Kandinsky, is an abstract-style oil-on-canvas painting.", R.drawable.daisy,
            29.9F,"https://i2.wp.com/bookmypainting.com/wp-content/uploads/2020/09/50.jpg?resize=517%2C362&ssl=1"))
        addItem(PlaceholderItem("9", "Adoration Of The Magi", "The Adoration of the Magi or Adoration of the Kings is the name historically given to the subject in Jesus’ Nativity in art where the three Magi, depicted as kings, particularly in the West, found Jesus by following a star, laid gifts of gold, frankincense, and myrrh before him, and worship him. ", R.drawable.daisy,
            19.9F,"https://i0.wp.com/bookmypainting.com/wp-content/uploads/2020/09/800px-Gentile_da_fabriano_adorazione_dei_magi.jpg?resize=512%2C324&ssl=1"))

    }

    private fun addItem(item: PlaceholderItem) {
        ITEMS.add(item)

        ITEM_MAP.put(item.id, item)
    }

    private fun createPlaceholderItem(position: Int): PlaceholderItem {
        return PlaceholderItem(position.toString(), "Item " + position, makeDetails(position), R.drawable.daisy,
            99.9F,"https://images.unsplash.com/photo-1583089892943-e02e5b017b6a?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=800&q=80")
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0..position - 1) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

    /**
     * A placeholder item representing a piece of content.
     */
    data class PlaceholderItem(val id: String, val content: String, val details: String,@DrawableRes
    val image: Int?, val price: Float, val imgURL:String) {
        override fun toString(): String = content
    }
}