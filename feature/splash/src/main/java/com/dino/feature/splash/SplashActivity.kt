package com.dino.feature.splash

import android.content.Intent
import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.core.net.toUri
import com.dino.core.ui.base.BaseActivity
import com.kakao.sdk.auth.AuthApiClient
import com.kakao.sdk.common.model.KakaoSdkError
import com.kakao.sdk.user.UserApiClient

class SplashActivity : BaseActivity() {
    override val content: @Composable () -> Unit = {
        SplashScreen()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (AuthApiClient.instance.hasToken()) {
            UserApiClient.instance.accessTokenInfo { _, error ->
                if (error != null) {
                    if (error is KakaoSdkError && error.isInvalidTokenError()) {
                        //로그인 필요
                        startActivity(Intent(Intent.ACTION_VIEW, "jeolyeomi://signin".toUri()))
                        finish()
                    } else {
                        //기타 에러
                    }
                } else {
                    //토큰 유효성 체크 성공(필요 시 토큰 갱신됨)
                    startActivity(Intent(Intent.ACTION_VIEW, "jeolyeomi://main".toUri()))
                    finish()
                }
            }
        } else {
            //로그인 필요
            startActivity(Intent(Intent.ACTION_VIEW, "jeolyeomi://signin".toUri()))
            finish()
        }
    }
}