package tw.waterdrop.autohotspot;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ComponentName component;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openAndroidPermissionsMenu();
        component = new ComponentName(getApplicationContext(), HotSpotChangeReceiver.class);

    }

    private void openAndroidPermissionsMenu() {
        if(!Settings.System.canWrite(this)){
            Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS,
                    Uri.parse("package:" + getPackageName()));
            startActivityForResult(intent, 0);
        }
        else
        {
            ApManager.configApState(getApplicationContext(), true);
        }

    }

    public void  startScan(View view)
    {
        Toast.makeText(MainActivity.this, "啟動偵測", Toast.LENGTH_SHORT).show();
        getApplicationContext().getPackageManager().setComponentEnabledSetting(component, PackageManager.COMPONENT_ENABLED_STATE_ENABLED , PackageManager.DONT_KILL_APP);
        ApManager.configApState(getApplicationContext(), true);

    }

    public void  stopScan(View view)
    {
        Toast.makeText(MainActivity.this, "停止偵測並關閉熱點", Toast.LENGTH_SHORT).show();
        getApplicationContext().getPackageManager().setComponentEnabledSetting(component, PackageManager.COMPONENT_ENABLED_STATE_DISABLED , PackageManager.DONT_KILL_APP);
        ApManager.configApState(getApplicationContext(), false);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0) {
            if (Settings.System.canWrite(this)) {
                Toast.makeText(MainActivity.this, "WRITE_SETTINGS permission granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "WRITE_SETTINGS permission not granted", Toast.LENGTH_SHORT).show();
            }
            ApManager.configApState(getApplicationContext(), true);
        }
    }


}
