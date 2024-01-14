package com.dino.feature.signin

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import kotlinx.coroutines.launch
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

@Composable
fun SignInScreen() {

    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column {
                Image(
                    modifier = Modifier
                        .height(48.dp)
                        .clickable {
                            coroutineScope.launch {
                                runCatching { loginKakao(context = context) }
                                    .onSuccess {
                                        Log.e("dino_log", "login 성공 ${it}")
                                        UserApiClient.instance.me { user, error ->
                                            Log.e("dino_log", "이름: ${user?.kakaoAccount?.name}")
                                        }
                                    }
                                    .onFailure {
                                        Log.e("dino_log", "login 실패 ${it}")
                                    }
                            }
                        },
                    painter = painterResource(id = R.drawable.kakao_login_large_narrow),
                    contentDescription = "카카오 로그인",
                    contentScale = ContentScale.FillHeight
                )
            }
        }
    }
}

private suspend fun loginKakao(
    context: Context,
): OAuthToken = suspendCoroutine { continuation ->
    // 카카오계정으로 로그인 공통 callback 구성
    // 카카오톡으로 로그인 할 수 없어 카카오계정으로 로그인할 경우 사용됨
    val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
        if (error != null) {
            continuation.resumeWithException(error)
        } else if (token != null) {
            continuation.resume(token)
        }
    }
    if (UserApiClient.instance.isKakaoTalkLoginAvailable(context = context)) {
        Log.e("dino_log", "카카오톡으로 로그인 가능")
        UserApiClient.instance
            .loginWithKakaoTalk(context = context) { token, error ->
                if (error != null) {
                    // 사용자가 카카오톡 설치 후 디바이스 권한 요청 화면에서 로그인을 취소한 경우,
                    // 의도적인 로그인 취소로 보고 카카오계정으로 로그인 시도 없이 로그인 취소로 처리 (예: 뒤로 가기)
                    if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                        callback(null, error)
                        return@loginWithKakaoTalk
                    }

                    // 카카오톡에 연결된 카카오계정이 없는 경우, 카카오계정으로 로그인 시도
                    UserApiClient.instance.loginWithKakaoAccount(context, callback = callback)
                } else if (token != null) {
                    callback(token, null)
                }
            }
    } else {
        Log.e("dino_log", "카카오톡으로 로그인 불가능")
        UserApiClient.instance.loginWithKakaoAccount(context, callback = callback)
    }
}