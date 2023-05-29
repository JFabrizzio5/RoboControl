package com.example.controlarduino;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private Button buttonW, buttonX, buttonC, buttonZ, buttonQ, buttonE, buttonS, buttonF;
    private BluetoothAdapter bluetoothAdapter;
    private BluetoothDevice bluetoothDevice;
    private BluetoothSocket bluetoothSocket;
    private OutputStream outputStream;

    private final String DEVICE_ADDRESS = "00:00:00:00:00:00"; // Reemplazar con la dirección MAC de tu dispositivo Bluetooth
    private final UUID UUID_SERIAL_PORT = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonW = findViewById(R.id.button_w);
        buttonX = findViewById(R.id.button_x);
        buttonC = findViewById(R.id.button_c);
        buttonZ = findViewById(R.id.button_z);
        buttonQ = findViewById(R.id.button_q);
        buttonE = findViewById(R.id.button_e);
        buttonS = findViewById(R.id.button_s);
        buttonF = findViewById(R.id.button_f);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        bluetoothDevice = bluetoothAdapter.getRemoteDevice(DEVICE_ADDRESS);

        buttonW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("w");
            }
        });

        buttonX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("x");
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("c");
            }
        });

        buttonZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("z");
            }
        });

        buttonQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("q");
            }
        });

        buttonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("e");
            }
        });

        buttonS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("s");
            }
        });

        buttonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData("f");
            }
        });
    }

    private void sendData(@NonNull String data) {
        try {
            bluetoothSocket = bluetoothDevice.createRfcommSocketToServiceRecord(UUID_SERIAL_PORT);
            bluetoothSocket.connect();
            outputStream = bluetoothSocket.getOutputStream();
            outputStream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bluetoothSocket != null) {
                try {
                    bluetoothSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
