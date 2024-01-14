package com.dino.jeolyeomi

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class JeolyeomiApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        KakaoSdk.init(this, BuildConfig.KAKAO_API_KEY)
    }
}