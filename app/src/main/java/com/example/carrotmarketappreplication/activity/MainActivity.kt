package com.example.carrotmarketappreplication.activity

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.DialogInterface
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.app.NotificationCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carrotmarketappreplication.MyDecoration
import com.example.carrotmarketappreplication.R
import com.example.carrotmarketappreplication.adapter.ItemClick
import com.example.carrotmarketappreplication.adapter.PostAdapter
import com.example.carrotmarketappreplication.data.PostDatabase.formDummyData
import com.example.carrotmarketappreplication.data.PostDatabase.totalPostData
import com.example.carrotmarketappreplication.data.PostInfo
import com.example.carrotmarketappreplication.databinding.ActivityMainBinding

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter by lazy {PostAdapter(arrayListOf())}



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }


    // 뒤로가기 BACK 버튼 클릭시 종료하시겠습니까? [확인][취소] 다이얼로그를 띄워주는 코드
    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)
        builder.create()
        builder.setTitle("종료하시겠습니까?")
        builder.setCancelable(false)
        builder.setPositiveButton("예", DialogInterface.OnClickListener { _, _ ->
            super.onBackPressed()
        })
        builder.setNegativeButton("아니오", DialogInterface.OnClickListener { _, _ ->

        })
        builder.show()
    }

    private fun initView() {

        notification()

        initRecyclerView()

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            // 2. Custom 구분선
            addItemDecoration(MyDecoration())
        }



        // 상단 툴바 제거
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.run {
            this!!.hide()
        }

        formDummyData()


//
//
//        val adapter = PostAdapter(totalPostData)
//        binding.recyclerView.adapter = adapter
//        binding.recyclerView.layoutManager = LinearLayoutManager(this)


    }

    private fun initRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)

            adapter = PostAdapter(totalPostData).apply {
                itemClick = object : ItemClick {
                    override fun onClick(view: View, position: Int) {
                        startActivity(DetailActivity.newIntent(this@MainActivity, totalPostData[position]))
                    }
                }

            }
        }
    }
    private fun notification() {
        binding.notificationButton.setOnClickListener {
            setNotice()
        }
    }

    private fun setNotice() {
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        val builder: NotificationCompat.Builder

        // 안드 8.0 Oreo 이상부터는 알림 채널을 먼저 만들어야 한다
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {  // Oreo, api26
            val channelId = "one-channel"
            manager.createNotificationChannel(
                NotificationChannel(
                    channelId, "My Channel One", NotificationManager.IMPORTANCE_DEFAULT
                ).apply {
                    description = "My Channel One Description"
                    setShowBadge(true)
                    val uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)!!
                    val audioAttributes = AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                        .setUsage(AudioAttributes.USAGE_ALARM)
                        .build()
                    setSound(uri, audioAttributes)
                    enableVibration(true)
                })
            builder = NotificationCompat.Builder(this, channelId)
        } else {  // < Oreo, api26
            @Suppress("DEPRECATION")
            builder = NotificationCompat.Builder(this)
        }

        // 알림에 띄울 이미지 비트맵이랑 실행시킬 인텐트 준비.
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.ic_notification)

        // 알림 정보
        // run 대신 apply 해도?
        builder.apply {
            setSmallIcon(R.mipmap.ic_launcher)
            setWhen(System.currentTimeMillis())
            setContentTitle("키워드 알림")
            setContentText("설정한 키워드에 대한 알림이 도착했습니다!!")
            setStyle(
                NotificationCompat.BigPictureStyle()
                    .bigPicture(bitmap)
            )
            setLargeIcon(bitmap)
        }

        manager.notify(11, builder.build())
    }



}