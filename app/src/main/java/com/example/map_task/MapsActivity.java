package com.example.map_task;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity  {

    private GoogleMap mMap,map2;
    Button b,b1,b2;
    FrameLayout l,l2;
    LatLng mylocation ,locationForMap2;
    Marker currentmarker;
    LatLng location;
    double lat,lng;
    Marker marker;
    SupportMapFragment mapFragment2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        b=findViewById(R.id.btn);
        b1=findViewById(R.id.btn2);
        l=findViewById(R.id.frame1);
        l2=findViewById(R.id.frame2);
        b2=findViewById(R.id.btn1);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
      //  mapFragment.getMapAsync(this);


            mapFragment2 = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map2);




        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            l.setVisibility(View.GONE);
            l2.setVisibility(View.VISIBLE);



            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             l2.setVisibility(View.GONE);
             l.setVisibility(View.VISIBLE);

            }
        });


        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;
                mMap.getUiSettings().setZoomControlsEnabled(true);
                mylocation = new LatLng(33.738045, 73.084488);
                currentmarker = mMap.addMarker(new MarkerOptions().position(mylocation).title(" title is this"));
              //  mMap.setInfoWindowAdapter(new info_window(this));

                //  mMap.addMarker(currentmarker.position(mylocation).title("location"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mylocation,10));
                currentmarker.remove();


                camera_idle();

           //  Toast.makeText(MapsActivity.this, lat+"latitude  fragments 1  + longitude"+lng, Toast.LENGTH_SHORT).show();





            }
        });



        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l.setVisibility(View.GONE);
                l2.setVisibility(View.VISIBLE);


                mapFragment2.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap googleMap) {
                        map2 = googleMap;
                        double lat = getlat();
                        double lng = getlng();


                   Toast.makeText(MapsActivity.this, lat + " :latitude map 2 + longitude :" + lng, Toast.LENGTH_SHORT).show();

                        double lata[] = {lat, 31.582045};
                        double lnga[] = {lng, 74.329376};

                        for (int i = 0; i < lata.length; i++) {


                          LatLng sydney = new LatLng(lata[i], lnga[i]);


                            if (marker == null) {

                                marker = map2.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
                                Toast.makeText(MapsActivity.this, "marker is null", Toast.LENGTH_SHORT).show();

                            } else if (marker != null) {


                                marker.remove();
                                Toast.makeText(MapsActivity.this, "marker is  not null", Toast.LENGTH_SHORT).show();
                                marker = map2.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
                                map2.setInfoWindowAdapter(new info_window(MapsActivity.this));
                                map2.moveCamera(CameraUpdateFactory.newLatLng(sydney));

                            }

                        }

                    }
                });
           }
        });
   }



   /* @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
       mMap.getUiSettings().setZoomControlsEnabled(true);
        mylocation = new LatLng(33.738045, 73.084488);
        currentmarker = mMap.addMarker(new MarkerOptions().position(mylocation).title(" title is this"));
        mMap.setInfoWindowAdapter(new info_window(this));

      //  mMap.addMarker(currentmarker.position(mylocation).title("location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mylocation,10));
        currentmarker.remove();


        camera_idle();
        double lat =getlat();
        double lng =getlng();
        Toast.makeText(MapsActivity.this, lat+"latitude + longitude"+lng, Toast.LENGTH_SHORT).show();
    }
    */





    public void camera_idle()
    {
    mMap.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {
        @Override
        public void onCameraIdle() {
         location  =mMap.getCameraPosition().target;

        if(currentmarker != null) {


            currentmarker.remove();


            currentmarker = mMap.addMarker(new MarkerOptions().position(location).title("Hello world"));
            mMap.setInfoWindowAdapter(new info_window(MapsActivity.this));
           // infowindow();
               setLat(location.latitude);
               setLng(location.longitude);

   //  Toast.makeText(MapsActivity.this, location.latitude + ": latitude + longitude :" + location.longitude, Toast.LENGTH_SHORT).show();

          //  Toast.makeText(MapsActivity.this, lat+"latitude  on camera idel + longitude"+lng, Toast.LENGTH_SHORT).show();

        }



        }
    });}












    void infowindow(){
     mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
         @Override
         public boolean onMarkerClick(Marker marker) {
             Toast.makeText(MapsActivity.this, "hello world", Toast.LENGTH_SHORT).show();

             return true;
         }
     });




    }






    public void setLat(double lat){
        this.lat=lat;


    }

    public void setLng(double lng){
        this.lng=lng;

    }



    public double getlat(){

        return  lat;


    }



   public double getlng(){

        return lng;
   }





 public  void hello(){


     Toast.makeText(this, "hello world", Toast.LENGTH_SHORT).show();


 }










}
