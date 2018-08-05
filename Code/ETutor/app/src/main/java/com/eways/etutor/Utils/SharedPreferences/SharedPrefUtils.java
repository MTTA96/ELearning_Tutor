package com.eways.etutor.Utils.SharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;


import com.eways.etutor.Utils.params.GlobalParams;

import java.util.HashSet;
import java.util.Set;

public class SharedPrefUtils {
	private final SharedPreferences preferences;
	private final String sharedPreferenceName = "elearning_user";
	private SharedPreferences.Editor editor;

	public interface OnChangeListener{
		void onChange();
	}

	private OnChangeListener onChangeListener;

	// Use instance field for listener
	// It will not be gc'd as long as this instance is kept referenced
	private SharedPreferences.OnSharedPreferenceChangeListener listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
		public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
			if(onChangeListener != null) {
				onChangeListener.onChange();
			}
		}
	};

	public SharedPrefUtils(Context context) {
		this.preferences = context.getSharedPreferences(sharedPreferenceName,
				Context.MODE_PRIVATE);
		this.editor = preferences.edit();

		this.preferences.registerOnSharedPreferenceChangeListener(listener);
	}

	public SharedPrefUtils(Context context, String fileName) {
		this.preferences = context.getSharedPreferences(fileName,
				Context.MODE_PRIVATE);

		this.editor = preferences.edit();

		this.preferences.registerOnSharedPreferenceChangeListener(listener);
	}

	// Notice: commit is synchronized, so it can slow down the performance;
	// apply, is save in sharedPref immediately (which is temporary memory),
	// then save in hard memory asynchronous without returning result.
	// If you don't read straight away after writing value in sharedPref (e.g singleton),
	// apply satisfies your need and improve performance.

	public void putString(String key, String value, boolean commit) {
		if (editor == null) {
			return;
		}

		if (value == null) {
			editor.remove(key).apply();
		} else {
			if(commit){
				editor.putString(key, value).commit();
			}else {
				editor.putString(key, value).apply();
			}
		}
	}

	public String getString(String key) {
		if (preferences.contains(key)) {
			return preferences.getString(key, "");
		}
		return null;
	}

	public void putStringSet(String key, HashSet<String> value, boolean commit){
		if (editor == null) {
			return;
		}

		if (value == null) {
			editor.remove(key).apply();
		} else {
			if(commit){
				editor.putStringSet(key, value).commit();
			}else {
				editor.putStringSet(key, value).apply();
			}
		}
	}

	public Set<String> getStringSet(String key) {
		if (preferences.contains(key)) {
			return preferences.getStringSet(key, null);
		}
		return null;
	}

	public void putInt(String key, int value, boolean commit) {
		if (editor == null) {
			return;
		}

		if(commit) {
			editor.putInt(key, value).commit();
		}else {
			editor.putInt(key, value).apply();
		}
	}

	public int getInt(String key) {
		if (preferences.contains(key)) {
			return preferences.getInt(key, -1);
		}
		return -1;
	}

    public int getInt(String key, int _default) {
        if (preferences.contains(key)) {
            return preferences.getInt(key, _default);
        }
        return _default;
    }

	public void putFloat(String key, float value, boolean commit) {
		if (editor == null) {
			return;
		}

		if(commit){
			editor.putFloat(key, value).commit();
		}else {
			editor.putFloat(key, value).apply();
		}
	}

	public float getFloat(String key) {
		if (preferences.contains(key)) {
			return preferences.getFloat(key, -1f);
		}
		return -1f;
	}

	public void putBoolean(String key, boolean value, boolean commit) {
		if (editor == null) {
			return;
		}

		if(commit){
			editor.putBoolean(key, value).commit();
		}else {
			editor.putBoolean(key, value).apply();
		}
	}

	public boolean getBoolean(String key) {
		if (preferences.contains(key)) {
			return preferences.getBoolean(key, false);
		}
		return false;
	}

    public void putLong(String key, long value, boolean commit) {
		if (editor == null) {
			return;
		}

		if(commit) {
			editor.putLong(key, value).commit();
		}else {
			editor.putLong(key, value).apply();
		}
    }

    public long getLong(String key) {
        if (preferences.contains(key)) {
            return preferences.getLong(key, -1);
        }
        return -1;
    }

    public <T> void putObject(String key, T data, boolean commit){

		if(commit) {
			editor.putString(key, GlobalParams.getInstance().getGSon().toJson(data)).commit();
		}else {
			editor.putString(key, GlobalParams.getInstance().getGSon().toJson(data)).apply();
		}
	}

    public <T> T getObject(String key, Class<T> anonymousClass){
		return (T) GlobalParams.getInstance()
				.getGSon()
				.fromJson(preferences.getString(key, ""), anonymousClass);
	}

	public void removeByKey(String key) {
		if (key != null && key != "" && preferences.contains(key)) {
			preferences.edit().remove(key).commit();
		}
	}

	public boolean containsKey(String key) {
		return preferences.contains(key);
	}

	public void clear() {
		preferences.edit().clear().commit();
	}

	public void setOnChangeListener(OnChangeListener onChangeListener) {
		this.onChangeListener = onChangeListener;
	}
}
