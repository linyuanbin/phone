
package com.A1.phone;
import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.telephony.gsm.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


@SuppressLint("NewApi") public class MainActivity extends ActionBarActivity {

	private EditText numberText;
	private EditText contentText;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
       numberText=(EditText) this.findViewById(R.id.number);
       contentText=(EditText) this.findViewById(R.id.content);
       Button button=(Button) this.findViewById(R.id.button);
       button.setOnClickListener(new ButtonClickListener());
        
    }
    //内部类
private final class ButtonClickListener implements View.OnClickListener{

	public void onClick(View v){
		String number=numberText.getText().toString();
		String content=contentText.getText().toString();
        SmsManager manager=SmsManager.getDefault();
        ArrayList<String>texts=manager.divideMessage(content);
        for(String text:texts){
        manager.sendTextMessage(number,null,text,null,null);            
        }
	
	Toast.makeText(MainActivity.this,R.string.success,Toast.LENGTH_LONG).show();
	
	}
}//内部类结束
    
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
