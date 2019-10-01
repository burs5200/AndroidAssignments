package com.example.androidassignments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class ChatWindow extends AppCompatActivity {
    private EditText textMessage;
    private ArrayList<String> mArray;
    private ChatAdapter messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);
        textMessage = findViewById(R.id.editText);
        Button sendButton = findViewById(R.id.button5);
        ListView messagesView = findViewById(R.id.ListView1);
        mArray = new ArrayList<>();
        messageAdapter = new ChatAdapter(this);
        messagesView.setAdapter(messageAdapter);
    }

    public void sendMessage(View view) {
        String message = textMessage.getText().toString();
        mArray.add(message);
        messageAdapter.notifyDataSetChanged(); //this restarts the process of getCount()/
        textMessage.setText("");


    }

    @SuppressWarnings("NullableProblems")
    class ChatAdapter extends ArrayAdapter<String> {
        private ChatAdapter(Context ctx) {
            super(ctx, 0);
        }

        public int getCount() {
            return mArray.size();
        }

        public String getItem(int position) {
            return mArray.get(position);
        }


        @SuppressWarnings("UnusedAssignment")
        @SuppressLint("InflateParams")
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = ChatWindow.this.getLayoutInflater();
            View result = null;
            if (position % 2 == 0)
                result = inflater.inflate(R.layout.chat_row_incoming, null);
            else
                result = inflater.inflate(R.layout.chat_row_outgoing, null);

            TextView message = result.findViewById(R.id.messageText);
            message.setText(getItem(position)); // get the string at position
            return result;


        }
    }
}
