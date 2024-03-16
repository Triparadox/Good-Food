package com.android.goodfood;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.AlertDialog;
import android.content.DialogInterface;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the global menu.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle selected menu item
        int id = item.getItemId();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        if (id == R.id.menuGlobalSettings) {
            builder.setMessage("App Settings is under development.")
                    .setTitle("App Settings");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // User clicked OK button
                }
            });
        }
        if (id == R.id.menuResetData) {
            builder.setMessage("Are you sure you want to delete ALL user data?")
                    .setTitle("Reset Data");
            builder.setPositiveButton("Reset Data", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // User resetted data
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // User aborted reset data
                }
            });
        }

        return super.onOptionsItemSelected(item);
    }
}