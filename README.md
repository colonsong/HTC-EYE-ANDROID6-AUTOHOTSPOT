# HTC-EYE-ANDROID6-AUTOHOTSPOT
因為HTC android6有自動熱點關閉的BUG, 希望每次自動關閉自動幫我打開

自己寫了個熱點自動重啟，希望能避免斷線時我不用一直跑去重按，星期一晚上來測試先上PLAY
https://play.google.com/store/apps/details?id=tw.waterdrop.autohotspot&hl=zh_TW

相關的技術文

流程是註冊一個Receiver - android.net.wifi.WIFI_AP_STATE_CHANGED
在AP狀態變動的情況下會收到Receiver自動重啟AP

receiver寫在mainfest裡為了應用程式結束時這receiver還是能夠被註冊
加了兩個button為了睡覺時能夠結束WIFI熱點並且停止繼續監聽熱點

參考

JAVA反射 https://getpocket.com/a/read/809459355

RECEIVER http://stackoverflow.com/questions/6529276/android-how-to-unregister-a-receiver-created-in-the-manifest
