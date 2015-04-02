package com.sdnmonitor.ransomer;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.rabbitmq.client.ConnectionFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Ray on 4/2/15.
 */
public class MQService extends IntentService {
    // Binder given to clients
    //private final IBinder mBinder = new MQBinder();

    /*
    MQBinder provides getService() method for clients to retrieve the current
    instance of MQService
    */

    public MQService() {
        super("MQService");
    }

    public int onStartCommand(Intent intent, int flags, int startId)
    {
        super.onStartCommand(intent, flags, startId);
        Toast.makeText(this, "MQService Started", Toast.LENGTH_LONG).show();

        // We want this service to stop after it has run once.
        return START_NOT_STICKY;
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        Toast.makeText(this, "MQService Handling Intent", Toast.LENGTH_LONG).show();
        // INSERT THE WORK TO BE DONE HERE

        /*
        factory.setHost("137.140.3.151");
        factory.setUsername("ransomer");
        factory.setPassword("*Sep91180");
        factory.setPort(15672);
        factory.setAutomaticRecoveryEnabled(true);
        */
        // connection that will recover automatically


    }



    @Override
    public void onCreate() {
        super.onCreate();


        Log.d("MQService", "Service created");
        Toast.makeText(this, "Service created ...", Toast.LENGTH_LONG).show();


    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d("MQService", "Service Destroyed");


    }


    ConnectionFactory factory = new ConnectionFactory();
    private void setupConnectionFactory() {

        final URI uri = URI.create("amqp://test:test@137.140.3.151:15672/");

        try {


            factory.setUri(uri);
        } catch (KeyManagementException | NoSuchAlgorithmException | URISyntaxException e1) {
            e1.printStackTrace();
        }
    }


}
