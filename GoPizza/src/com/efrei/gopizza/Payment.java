package com.efrei.gopizza;

import com.example.gopizza.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import com.paypal.android.sdk.payments.PayPalAuthorization;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalFuturePaymentActivity;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONException;

import java.math.BigDecimal;

public class Payment extends Activity {
	
	public static boolean fastMode = false;

	private static final String TAG = "paymentExample";
	/**
	 * - Set to PaymentActivity.ENVIRONMENT_PRODUCTION to move real money.
	 * 
	 * - Set to PaymentActivity.ENVIRONMENT_SANDBOX to use your test credentials
	 * from https://developer.paypal.com
	 * 
	 * - Set to PayPalConfiguration.ENVIRONMENT_NO_NETWORK to kick the tires
	 * without communicating to PayPal's servers.
	 */
	// private static final String CONFIG_ENVIRONMENT =
	// PayPalConfiguration.ENVIRONMENT_NO_NETWORK;
	private static final String CONFIG_ENVIRONMENT = PayPalConfiguration.ENVIRONMENT_SANDBOX;

	// note that these credentials will differ between live & sandbox
	// environments.
	private static final String CONFIG_CLIENT_ID = "AZpIO9-36g-Iaozkx-7sQz2NgNuVsiueGDMj3svv1ZDRTzrSxv9E5x1e0xwKvIyrVFmMRGNfjHuBLGlu";

	private static final int REQUEST_CODE_PAYMENT = 1;
	private static final int REQUEST_CODE_FUTURE_PAYMENT = 2;

	private static PayPalConfiguration config = new PayPalConfiguration()
			.environment(CONFIG_ENVIRONMENT)
			.clientId(CONFIG_CLIENT_ID)
			// The following are only used in PayPalFuturePaymentActivity.
			.merchantName("Hipster Store")
			.merchantPrivacyPolicyUri(
					Uri.parse("https://www.example.com/privacy"))
			.merchantUserAgreementUri(
					Uri.parse("https://www.example.com/legal"));

	PayPalPayment thingToBuy;

	private Button PaymentButton, ButtonGoBack;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// Enlever la title bar de l'application
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		super.onCreate(savedInstanceState);

		setContentView(R.layout.payment_fullscreen);

		generateQRCode("https://github.com/n3ocat/efreiProjects/tree/master/GoPizza");

		Intent intent = new Intent(this, PayPalService.class);
		intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
		startService(intent);
		
		PaymentButton = (Button)findViewById(R.id.paymentButton);
		ButtonGoBack = (Button)findViewById(R.id.buttonGoBack);
		
		ButtonGoBack.setClickable(false);
		ButtonGoBack.setEnabled(false);
		
		ButtonGoBack.setOnClickListener(goBack);
		
	}

	public void generateQRCode(String url) {

		QRCodeWriter writer = new QRCodeWriter();
		try {
			BitMatrix bitMatrix = writer.encode(url, BarcodeFormat.QR_CODE,
					512, 512);
			int width = bitMatrix.getWidth();
			int height = bitMatrix.getHeight();
			Bitmap bmp = Bitmap.createBitmap(width, height,
					Bitmap.Config.RGB_565);
			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					bmp.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK
							: Color.WHITE);
				}
			}
			((ImageView) findViewById(R.id.qrcode)).setImageBitmap(bmp);

		} catch (WriterException e) {
			e.printStackTrace();
		}

	}

	public void onBuyPressed(View pressed) {
		// PAYMENT_INTENT_SALE will cause the payment to complete immediately.
		// Change PAYMENT_INTENT_SALE to PAYMENT_INTENT_AUTHORIZE to only
		// authorize payment and
		// capture funds later.

	
		if (pressed.getId() == R.id.paymentButton) {
			
			PaymentButton.setClickable(false);
			PaymentButton.setEnabled(false);
			
			ButtonGoBack.setClickable(true);
			ButtonGoBack.setEnabled(true);
			
			if (!fastMode) {
				
				thingToBuy = new PayPalPayment(new BigDecimal(Order.totalOrder),
						"EUR", "Pizza command", PayPalPayment.PAYMENT_INTENT_SALE);
			} else {
				
				SharedPreferences sharedPreferences = getSharedPreferences("My_pref", Activity.MODE_PRIVATE);
				String favoritePizza = sharedPreferences.getString("spin1Saved", "Favorite pizza 1st : Reine");
				
				switch (favoritePizza) {
				
				case "Favorite pizza 1st : Reine" :
					
					thingToBuy = new PayPalPayment(new BigDecimal(9),
							"EUR", "Fast & Furious, pizza : Reine", PayPalPayment.PAYMENT_INTENT_SALE);
					break;
					
				case "Favorite pizza 1st : 4Fromages" :
					
					thingToBuy = new PayPalPayment(new BigDecimal(9),
							"EUR", "Fast & Furious, pizza : Quatre fromages", PayPalPayment.PAYMENT_INTENT_SALE);
					break;
									
				case "Favorite pizza 1st : Margherita" :
					
					thingToBuy = new PayPalPayment(new BigDecimal(7),
							"EUR", "Fast & Furious, pizza : Margherita", PayPalPayment.PAYMENT_INTENT_SALE);
					break;
					
				case "Favorite pizza 1st : Cannibale" :
					
					thingToBuy = new PayPalPayment(new BigDecimal(11),
							"EUR", "Fast & Furious, pizza : Cannibale", PayPalPayment.PAYMENT_INTENT_SALE);
					break;
					
				case "Favorite pizza 1st : Forestière" :
					
					thingToBuy = new PayPalPayment(new BigDecimal(8),
							"EUR", "Fast & Furious, pizza : Forestière", PayPalPayment.PAYMENT_INTENT_SALE);
					break;
					
				case "Favorite pizza 1st : Indienne" :
					
					thingToBuy = new PayPalPayment(new BigDecimal(9),
							"EUR", "Fast & Furious, pizza : Indienne", PayPalPayment.PAYMENT_INTENT_SALE);
					break;
					
				case "Favorite pizza 1st : Orientale" :
					
					thingToBuy = new PayPalPayment(new BigDecimal(10),
							"EUR", "Fast & Furious, pizza : Orientale", PayPalPayment.PAYMENT_INTENT_SALE);
					break;
					
				case "Favorite pizza 1st : Saumoneta" :
					
					thingToBuy = new PayPalPayment(new BigDecimal(11),
							"EUR", "Fast & Furious, pizza : Saumoneta", PayPalPayment.PAYMENT_INTENT_SALE);
					break;
					
				case "Favorite pizza 1st : Savoyarde" :
					
					thingToBuy = new PayPalPayment(new BigDecimal(12),
							"EUR", "Fast & Furious, pizza : Savoyarde", PayPalPayment.PAYMENT_INTENT_SALE);
					break;

				}
				
			}
			
		}

		Intent intent = new Intent(Payment.this, PaymentActivity.class);

		intent.putExtra(PaymentActivity.EXTRA_PAYMENT, thingToBuy);

		startActivityForResult(intent, REQUEST_CODE_PAYMENT);
		
	}

	public void onFuturePaymentPressed(View pressed) {

		Intent intent = new Intent(Payment.this,
				PayPalFuturePaymentActivity.class);
		startActivityForResult(intent, REQUEST_CODE_FUTURE_PAYMENT);

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REQUEST_CODE_PAYMENT) {
			if (resultCode == Activity.RESULT_OK) {
				PaymentConfirmation confirm = data
						.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
				if (confirm != null) {
					try {
						Log.i(TAG, confirm.toJSONObject().toString(4));
						Log.i(TAG, confirm.getPayment().toJSONObject()
								.toString(4));

						Toast.makeText(
								getApplicationContext(),
								"PaymentConfirmation info received from PayPal",
								Toast.LENGTH_LONG).show();

					} catch (JSONException e) {
						Log.e(TAG, "an extremely unlikely failure occurred: ",
								e);
					}
				}
			} else if (resultCode == Activity.RESULT_CANCELED) {
				Log.i(TAG, "The user canceled.");
			} else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID) {
				Log.i(TAG,
						"An invalid Payment or PayPalConfiguration was submitted. Please see the docs.");
			}
		} else if (requestCode == REQUEST_CODE_FUTURE_PAYMENT) {
			if (resultCode == Activity.RESULT_OK) {
				PayPalAuthorization auth = data
						.getParcelableExtra(PayPalFuturePaymentActivity.EXTRA_RESULT_AUTHORIZATION);
				if (auth != null) {
					try {
						Log.i("FuturePaymentExample", auth.toJSONObject()
								.toString(4));

						String authorization_code = auth.getAuthorizationCode();
						Log.i("FuturePaymentExample", authorization_code);

						sendAuthorizationToServer(auth);
						Toast.makeText(getApplicationContext(),
								"Future Payment code received from PayPal",
								Toast.LENGTH_LONG).show();

					} catch (JSONException e) {
						Log.e("FuturePaymentExample",
								"an extremely unlikely failure occurred: ", e);
					}
				}
			} else if (resultCode == Activity.RESULT_CANCELED) {
				Log.i("FuturePaymentExample", "The user canceled.");
			} else if (resultCode == PayPalFuturePaymentActivity.RESULT_EXTRAS_INVALID) {
				Log.i("FuturePaymentExample",
						"Probably the attempt to previously start the PayPalService had an invalid PayPalConfiguration. Please see the docs.");
			}
		}
	}

	private void sendAuthorizationToServer(PayPalAuthorization authorization) {

	}

	public void onFuturePaymentPurchasePressed(View pressed) {
		// Get the Application Correlation ID from the SDK
		String correlationId = PayPalConfiguration
				.getApplicationCorrelationId(this);

		Log.i("FuturePaymentExample", "Application Correlation ID: "
				+ correlationId);

		// TODO: Send correlationId and transaction details to your server for
		// processing with
		// PayPal...
		Toast.makeText(getApplicationContext(),
				"App Correlation ID received from SDK", Toast.LENGTH_LONG)
				.show();
	}
	
	View.OnClickListener goBack = new View.OnClickListener() {

	    public void onClick(View v) {
	    	
	    	Pizzamenu.pizzaOrderedList.clear();
	    	startActivity(new Intent(Payment.this, Mainmenu.class));
	    	finish();
	    	
	    }
	    
	};

	@Override
	public void onDestroy() {
		// Stop service when done
		stopService(new Intent(this, PayPalService.class));
		super.onDestroy();
	}

	@Override
	public void onBackPressed() {

		if (fastMode) {
			
			startActivity(new Intent(Payment.this, Mainmenu.class));
			finish();
			
		} else {
			
			startActivity(new Intent(Payment.this, Order.class));
			finish();
			
		}

	}

}
