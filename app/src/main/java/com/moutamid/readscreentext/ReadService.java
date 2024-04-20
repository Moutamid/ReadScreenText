package com.moutamid.readscreentext;

import android.accessibilityservice.AccessibilityService;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Toast;

public class ReadService extends AccessibilityService {
    private static final String TAG = "ReadService";

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        Toast.makeText(getApplicationContext(), "Connected!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        if (event.getSource() == null) {
            return;
        }

        traverseViewHierarchy(event.getSource());
        event.getSource().recycle();

//        StringBuilder textBuilder = new StringBuilder();
//        for (CharSequence charSequence : event.getText()) {
//            textBuilder.append(charSequence);
//        }
//        String text = textBuilder.toString();
//
//        // Log the extracted text
//        Log.d(TAG, "Extracted Text: " + text);
    }

    private void traverseViewHierarchy(AccessibilityNodeInfo node) {
        if (node == null) {
            return;
        }

        if (node.getText() != null && !node.getText().toString().isEmpty()) {
            Log.d(TAG, "Extracted Text: " + node.getText());
        }

        for (int i = 0; i < node.getChildCount(); i++) {
            traverseViewHierarchy(node.getChild(i));
        }
    }

    @Override
    public void onInterrupt() {

    }
}
