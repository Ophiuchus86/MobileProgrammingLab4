package com.github.ophiuchus86.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class UniversityActivity extends AppCompatActivity {
    TextView universityName;
    TextView universityCountry;
    TextView universityDomains;
    TextView universityPages;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university);

        universityName = findViewById(R.id.university_name);
        universityCountry = findViewById(R.id.university_country);
        universityDomains = findViewById(R.id.university_domains);
        universityPages = findViewById(R.id.university_pages);

        Intent intent = getIntent();
        universityName.setText(intent.getStringExtra("name"));
        universityCountry.setText(intent.getStringExtra("country"));

        ArrayList<String> domains = intent.getStringArrayListExtra("domains");
        universityDomains.setText(domains.toString());
//        StringBuilder domainsString = new StringBuilder();
//        for(String domain: domains)
//            domainsString.append(domain).append("\n");
//        universityDomains.setText(domainsString);
//
        ArrayList<String> pages = intent.getStringArrayListExtra("pages");
        universityPages.setText(pages.toString());
//        StringBuilder pagesString = new StringBuilder();
//        for(String page: pages)
//            pagesString.append(page).append("\n");


    }
}
