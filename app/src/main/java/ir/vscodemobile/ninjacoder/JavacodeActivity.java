package ir.vscodemobile.ninjacoder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import java.util.ArrayList;
import java.util.HashMap;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.view.View;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import android.graphics.Typeface;
import androidx.webkit.*;
import mrAr.Stop.notmeDicompile.*;
import s4u.restore.swb.*;
import com.jtv7.rippleswitchlib.*;
import com.android.tools.r8.*;
import com.lwb.piechart.*;
import net.lingala.zip4j.*;
import io.github.rosemoe.sora.langs.textmate.*;
import io.github.rosemoe.sora.langs.base.*;
import com.github.underscore.lodash.*;
import com.example.myapp.*;
import org.jetbrains.kotlin.*;
import com.suke.widget.*;
import com.google.gson.*;
import com.github.angads25.filepicker.*;
import io.github.rosemoe.sora.*;
import com.android.*;
import com.googlecode.d2j.*;
import dos.ir.res.*;
import com.caverock.androidsvg.*;
import org.antlr.v4.runtime.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import io.github.rosemoe.sora.widget.CodeEditor;
import ir.vscodemobile.ninjacoder.theme;
import io.github.rosemoe.sora.langs.java.*;
import io.github.rosemoe.sora.langs.java.JavaLanguage;

public class JavacodeActivity extends AppCompatActivity {
	
	private String g = "";
	
	private ArrayList<HashMap<String, Object>> f = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private ListView listview1;
	private EditText e;
	private ImageView q;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.javacode);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		listview1 = findViewById(R.id.listview1);
		e = findViewById(R.id.e);
		q = findViewById(R.id.q);
		
		q.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				listview1.setAdapter(new Listview1Adapter(f));
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
				return true;
			}
		});
		
		q.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final double length = f.size();
				 
				d = f.size() - 1;
				 for(int i = 0; i < (int)(length); i++) {
					  final String serching = f.get((int)d).get("title").toString();
					  if (serching.toLowerCase().contains(e.getText().toString().toLowerCase())) {
						   
						  }else {
						   f.remove((int)(d));
						  }
					  d--;
					 }
				
				listview1.setAdapter(new Listview1Adapter(f));
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
				
			}
			private double d;
			{
			}
		});
	}
	
	private void initializeLogic() {
		try{
				java.io.InputStream gIn = this.getAssets().open("co");
				           int gSi = gIn.available();
				           byte[] gBu = new byte[gSi];
				           gIn.read(gBu);
				           gIn.close();
				           g = new String(gBu, "UTF-8");
		}catch(Exception e){
				 
		}
		f = new Gson().fromJson(g, new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		listview1.setAdapter(new Listview1Adapter(f));
		((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
	}
	
	public class Listview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.nop, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			
			textview1.setText(f.get((int)_position).get("title").toString());
			linear1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)21, 0xFF000062));
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					final AlertDialog dialog1 = new AlertDialog.Builder(JavacodeActivity.this).create();
					View inflate = getLayoutInflater().inflate(R.layout.javaview,null); 
					dialog1.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
					dialog1.setView(inflate);
					androidx.cardview.widget.CardView card = (androidx.cardview.widget.CardView) inflate.findViewById(R.id.card);
					io.github.rosemoe.sora.widget.CodeEditor editor = (io.github.rosemoe.sora.widget.CodeEditor) inflate.findViewById(R.id.editor);
					TextView a = (TextView) inflate.findViewById(R.id.a);
					LinearLayout z = (LinearLayout) inflate.findViewById(R.id.z);
					Button btn1 = (Button) inflate.findViewById(R.id.btn1);
					Button btn2 = (Button) inflate.findViewById(R.id.btn2);
					editor.setColorScheme(new theme());
					editor.setEditorLanguage(new JavaLanguage()); 
					editor.setText(f.get((int)_position).get("code").toString());
					card.setCardBackgroundColor(0xFF000027);
					card.setRadius((float)19);
					card.setCardElevation((float)1);
					btn1.setTextColor(0xFFFFFFFF);
					btn2.setTextColor(0xFFFFFFFF);
					btn1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/myf.ttf"), 1);
					btn2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/myf.ttf"), 1);
					btn2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)15, 0xFFFF8800));
					btn1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)15, 0xFFFF8800));
					z.setElevation((float)6);
					a.setText(f.get((int)_position).get("title").toString());
					btn1.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
									
								try {
								android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(CLIPBOARD_SERVICE); 
								ClipData clip = ClipData.newPlainText("label", editor.getText().toString());
								clipboard.setPrimaryClip(clip);
							} catch (Exception e) {
								e.printStackTrace();
							}
							SketchwareUtil.CustomToast(getApplicationContext(), "👍", 0xFFFFFFFF, 15, 0xFFE91E63, 25, SketchwareUtil.CENTER);
							dialog1.dismiss();
							
							}
					});
					btn2.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
									
								dialog1.dismiss();
							
							}
					});
					dialog1.setCancelable(true);
					dialog1.show();
				}
			});
			
			return _view;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}