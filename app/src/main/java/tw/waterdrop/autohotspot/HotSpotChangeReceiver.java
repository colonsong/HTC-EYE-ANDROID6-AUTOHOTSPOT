package tw.waterdrop.autohotspot;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class HotSpotChangeReceiver extends BroadcastReceiver {
    public HotSpotChangeReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //检查返回结果
        Toast.makeText(context, " 偵測到熱點狀態變動 ", Toast.LENGTH_SHORT).show();
        Log.d(getClass().toString(), "偵測到熱點狀態變動" );
        ApManager.configApState(context, true);
    }
}
