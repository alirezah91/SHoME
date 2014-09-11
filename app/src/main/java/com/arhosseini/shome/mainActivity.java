package com.arhosseini.shome;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class mainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    public void clickLighting(View view) {
        // Do something in response to button click
        String ip = PreferenceManager.getDefaultSharedPreferences(getBaseContext()).getString("ip", "192.168.1.2");

        WebView webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://" + ip + "/myhome/lightings.php");
    }

    public void clickTemp(View view) {
        // Do something in response to button click
        String ip = PreferenceManager.getDefaultSharedPreferences(getBaseContext()).getString("ip", "192.168.1.2");

        WebView webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://" + ip + "/myhome/temperatures.php");
    }

    public void clickScenario(View view) {
        // Do something in response to button click
        String ip = PreferenceManager.getDefaultSharedPreferences(getBaseContext()).getString("ip", "192.168.1.2");

        WebView webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://" + ip + "/myhome/scenarios.php");
    }

    public void clickLock(View view) {
        // Do something in response to button click
        String ip = PreferenceManager.getDefaultSharedPreferences(getBaseContext()).getString("ip", "192.168.1.2");

        WebView webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://" + ip + "/myhome/locks.php");
    }


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
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);



            return true;
        }
        else if(id == R.id.action_refresh) {
            String ip = PreferenceManager.getDefaultSharedPreferences(getBaseContext()).getString("ip", "192.168.1.2");

            WebView webView = (WebView) findViewById(R.id.webView);
            webView.setWebViewClient(new WebViewClient());
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl("http://" + ip + "/myhome");

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            String ip = PreferenceManager.getDefaultSharedPreferences(getActivity().getBaseContext()).getString("ip", "192.168.1.2");

            WebView webView = (WebView) rootView.findViewById(R.id.webView);
            webView.setWebViewClient(new WebViewClient());
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl("http://" + ip + "/myhome");

            return rootView;
        }
    }
}
