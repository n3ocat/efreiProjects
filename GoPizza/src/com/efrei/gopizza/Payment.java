package com.efrei.gopizza;

import com.example.gopizza.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

public class Payment extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// Enlever la title bar de l'application
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		super.onCreate(savedInstanceState);

		setContentView(R.layout.payment_fullscreen);

		generateQRCode("https://github.com/n3ocat/efreiProjects/tree/master/GoPizza");

	}

	public void generateQRCode(String url) {

		QRCodeWriter writer = new QRCodeWriter();
	    try {
	        BitMatrix bitMatrix = writer.encode(url, BarcodeFormat.QR_CODE, 512, 512);
	        int width = bitMatrix.getWidth();
	        int height = bitMatrix.getHeight();
	        Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
	        for (int x = 0; x < width; x++) {
	            for (int y = 0; y < height; y++) {
	                bmp.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
	            }
	        }
	        ((ImageView) findViewById(R.id.qrcode)).setImageBitmap(bmp);

	    } catch (WriterException e) {
	        e.printStackTrace();
	    }

	}

	@Override
	public void onBackPressed() {

		startActivity(new Intent(Payment.this, Order.class));
		finish();

	}

}
